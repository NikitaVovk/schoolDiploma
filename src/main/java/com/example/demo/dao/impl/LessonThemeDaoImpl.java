package com.example.demo.dao.impl;


import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.LessonThemeDao;
import com.example.demo.domain.HomeWork;
import com.example.demo.domain.LessonTheme;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Transactional
@Repository("lessonThemeDao")
public class LessonThemeDaoImpl extends AbstractDao<Long, LessonTheme> implements LessonThemeDao {


    @Override
    public LessonTheme findLessonThemeByIdTscAndDate(Long idTSC, Date date) {
        Query query = createQuery("SELECT  lt FROM LessonTheme lt, TeacherSubjectClass tsc where lt.tsc=tsc.id and tsc.id=:idTSC and date(lt.date) >= date(:date) and date(lt.date) < date(:date1)");
        query.setParameter("idTSC", idTSC);
        query.setParameter("date",date.toString());
        query.setParameter("date1",new Date(date.getYear(),date.getMonth(),date.getDate()+1).toString());
        return (LessonTheme) query.uniqueResult();
    }

    @Override
    public void addLessonTheme(LessonTheme lessonTheme) {
persist(lessonTheme);
    }

    @Override
    public void deleteLessonTheme(LessonTheme lessonTheme) {
delete(lessonTheme);
    }

    @Override
    public void updateLessonTheme(LessonTheme lessonTheme) {
update(lessonTheme);
    }
}
