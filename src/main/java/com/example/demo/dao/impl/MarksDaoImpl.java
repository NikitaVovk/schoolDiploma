package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.MarksDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.domain.Marks;
import com.example.demo.domain.Student;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sun.jvm.hotspot.oops.Mark;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository("marksDao")
public class MarksDaoImpl extends AbstractDao<Long, Marks> implements MarksDao {
    @Override
    public List<Marks> findMarksByIdStudentAndIdSubject(Long idStudent, Long idSubject) {
        Query query = createQuery("SELECT  m FROM Marks m, Student st, Subject s where m.student=st.idstudent and m.subject=s.idsubject and st.idstudent=:idStudent and s.idsubject=:idSubject order by m.date");
        query.setParameter("idStudent", idStudent);
        query.setParameter("idSubject", idSubject);
        List<Marks> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public List<Marks> findMarksByIdStudentAndDate(Long idStudent, Date date) {
        Query query = createQuery("SELECT  m FROM Marks m, Student st where m.student=st.idstudent  and st.idstudent=:idStudent and date(m.date) >= date(:date) and date(m.date) < date(:date1)");
        query.setParameter("idStudent", idStudent);
        query.setParameter("date", date);
        query.setParameter("date1", new Date(date.getYear(),date.getMonth(),date.getDate()+1).toString());

        List<Marks> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public Marks findMarksByIdStudentAndIdSubjectAndDate(Long idStudent, Long idSubject, java.sql.Date date) {
     //   System.out.println(date+" time"+date.getTime()+"kekusss\n\n\n\n");
        //System.out.println(this.findMarkByIdMark(56L).getDate()+" time "+this.findMarkByIdMark(56L).getDate().getTime()+"kekusss\n\n\n\n");
      //  System.out.println(new Date(date.getYear(),date.getMonth(),date.getDate()+1)+" time"+new Date(date.getYear(),date.getMonth(),date.getDate()+1).getTime()+"kekusss\n\n\n\n");

        //SELECT  m.mark FROM Marks m, Student st, Subject s where m.student_idstudent=st.idstudent and m.subject_idsubject=s.idsubject and st.idstudent=1 and s.idsubject=1 and m.date="2019-10-16"
        Query query = createQuery("SELECT  m FROM Marks m, Student st, Subject s where m.student=st.idstudent and m.subject=s.idsubject and st.idstudent=:idStudent and s.idsubject=:idSubject and date(m.date) >= date(:date) and date(m.date) < date(:date1)");
        query.setParameter("idStudent", idStudent);
        query.setParameter("idSubject", idSubject);
        query.setParameter("date",date.toString());
        query.setParameter("date1",new Date(date.getYear(),date.getMonth(),date.getDate()+1).toString());
        return (Marks)query.uniqueResult();
    }

    @Override
    public Marks findMarkByIdMark(Long idMark) {
        return getByKey(idMark);
    }

    @Override
    public void addMarks(Marks marks) {
persist(marks);
    }

    @Override
    public void deleteMarks(Marks marks) {
delete(marks);
    }

    @Override
    public void updateMarks(Marks marks) {
update(marks);
    }


}