package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.FrequencyDao;
import com.example.demo.domain.Frequency;
import com.example.demo.domain.Marks;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
@Transactional
@Repository("frequencyDao")
public class FrequencyDaoImpl extends AbstractDao<Long, Frequency> implements FrequencyDao {
    @Override
    public List<Frequency> findFrequencyByIdStudentAndIdSubject(Long idStudent, Long idSubject) {
        Query query = createQuery("SELECT  f FROM Frequency f, Student st, Subject s where f.student=st.idstudent and f.subject=s.idsubject and st.idstudent=:idStudent and s.idsubject=:idSubject order by f.date");
        query.setParameter("idStudent", idStudent);
        query.setParameter("idSubject", idSubject);
        List<Frequency> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public List<Frequency> findFrequencyByIdStudentAndDate(Long idStudent, Date date) {
        Query query = createQuery("SELECT  f FROM Frequency f, Student st where f.student=st.idstudent  and st.idstudent=:idStudent and date(f.date) >= date(:date) and date(f.date) < date(:date1)");
        query.setParameter("idStudent", idStudent);
        query.setParameter("date", date);
        query.setParameter("date1", new Date(date.getYear(),date.getMonth(),date.getDate()+1).toString());

        List<Frequency> listOfFrequency = query.list();
        if(listOfFrequency==null)
            return Collections.emptyList();
        return  listOfFrequency;
    }

    @Override
    public Frequency findFrequencyByIdStudentAndIdSubjectAndDate(Long idStudent, Long idSubject, Date date) {
        Query query = createQuery("SELECT  f FROM Frequency f, Student st, Subject s where f.student=st.idstudent and f.subject=s.idsubject and st.idstudent=:idStudent and s.idsubject=:idSubject and date(f.date) >= date(:date) and date(f.date) < date(:date1)");
        query.setParameter("idStudent", idStudent);
        query.setParameter("idSubject", idSubject);
        query.setParameter("date",date.toString());
        query.setParameter("date1",new Date(date.getYear(),date.getMonth(),date.getDate()+1).toString());
        return (Frequency)query.uniqueResult();
    }

    @Override
    public Frequency findFrequencyByIdMark(Long idFrequency) {
        return null;
    }

    @Override
    public void addFrequency(Frequency frequency) {
persist(frequency);
    }

    @Override
    public void deleteFrequency(Frequency frequency) {
delete(frequency);
    }

    @Override
    public void updateFrequency(Frequency frequency) {
update(frequency);
    }
}
