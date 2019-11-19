package com.example.demo.dao.impl;


import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.TestDao;
import com.example.demo.domain.Frequency;
import com.example.demo.domain.HomeWork;
import com.example.demo.domain.Test;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository("testDao")
public class TestDaoImpl extends AbstractDao<Long, Test> implements TestDao {
    @Override
    public List<Test> findTestByIdTSC(Long idTSC) {
        Query query = createQuery("SELECT  t FROM Test t, TeacherSubjectClass tsc where t.tsc=tsc.id and tsc.id=:idTSC order by t.date");
        query.setParameter("idTSC", idTSC);
        List<Test> listOfTest = query.list();
        if(listOfTest==null)
            return Collections.emptyList();
        return  listOfTest;
    }

    @Override
    public Test findTestByIdTSCAndDate(Long idTSC, Date date) {
        Query query = createQuery("SELECT  t FROM Test t, TeacherSubjectClass tsc where t.tsc=tsc.id and tsc.id=:idTSC and date(t.date) >= date(:date) and date(t.date) < date(:date1)");
        query.setParameter("idTSC", idTSC);
        query.setParameter("date",date.toString());
        query.setParameter("date1",new Date(date.getYear(),date.getMonth(),date.getDate()+1).toString());
        return (Test) query.uniqueResult();
    }

    @Override
    public List<Test> findTestByIdClassAndBetweenDates(Long idClass, Date date1, Date date2) {
        Query query = createQuery("SELECT  t FROM Test t, TeacherSubjectClass tsc, Class c where t.tsc=tsc.id and tsc.aClass=c.idclass and c.idclass=:idClass and  date(t.date) >= date(:date1) and date(t.date) <= date(:date2) order by t.date");
        query.setParameter("idClass", idClass);
        query.setParameter("date1",date1.toString());
        query.setParameter("date2",date2.toString());
        List<Test> listOfTest = query.list();
        if(listOfTest==null)
            return Collections.emptyList();
        return  listOfTest;
    }

    @Override
    public void addTest(Test test) {
    persist(test);
    }

    @Override
    public void deleteTest(Test test) {
delete(test);
    }

    @Override
    public void updateTest(Test test) {
update(test);
    }
}
