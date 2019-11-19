package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.HomeWorkDao;
import com.example.demo.domain.HomeWork;
import com.example.demo.domain.Marks;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;


@Transactional
@Repository("homeWorkDao")
public class HomeWorkDaoImpl extends AbstractDao<Long, HomeWork> implements HomeWorkDao {

    @Override
    public HomeWork findHomeWorkByIdTscAndDateAdded(Long idTSC, Date date) {
        Query query = createQuery("SELECT  h FROM HomeWork h, TeacherSubjectClass tsc where h.tsc=tsc.id and tsc.id=:idTSC and date(h.dateAdded) >= date(:date) and date(h.dateAdded) < date(:date1)");
        query.setParameter("idTSC", idTSC);
        query.setParameter("date",date.toString());
        query.setParameter("date1",new Date(date.getYear(),date.getMonth(),date.getDate()+1).toString());
        return (HomeWork) query.uniqueResult();
    }

    @Override
    public HomeWork findHomeWorkByIdTscAndDateDue(Long idTSC, Date date) {
        Query query = createQuery("SELECT  h FROM HomeWork h, TeacherSubjectClass tsc where h.tsc=tsc.id and tsc.id=:idTSC and date(h.dateDue) >= date(:date) and date(h.dateDue) < date(:date1)");
        query.setParameter("idTSC", idTSC);
        query.setParameter("date",date.toString());
        query.setParameter("date1",new Date(date.getYear(),date.getMonth(),date.getDate()+1).toString());
        return (HomeWork) query.uniqueResult();
    }

    @Override
    public void addHomeWork(HomeWork homeWork) {
persist(homeWork);
    }

    @Override
    public void deleteHomeWork(HomeWork homeWork) {
delete(homeWork);
    }

    @Override
    public void updateHomeWork(HomeWork homeWork) {
update(homeWork);
    }
}
