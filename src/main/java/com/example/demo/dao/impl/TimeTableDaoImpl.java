package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.TeacherDao;
import com.example.demo.dao.TimeTableDao;
import com.example.demo.domain.*;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository("timeTableDao")
public class TimeTableDaoImpl extends AbstractDao<Long, TimeTable> implements TimeTableDao {
//    @Override
//    public TimeTable findTimeTableByIdTSC(Long id) {
//        Query query = createQuery("select t from TimeTable t, TeacherSubjectClass tsc where t.teacherSubjectClass = tsc.id and tsc.id =:id");
//        query.setParameter("id", id);
//        return (TimeTable) query.uniqueResult();
//    }

    @Override
    public List<DaysOfWeek> findDaysByIdTSC(Long id) {
        Query query = createQuery("select d from DaysOfWeek d, TimeTable t, TeacherSubjectClass tsc where t.daysOfWeek=d.id and t.teacherSubjectClass = tsc.id and tsc.id =:id ");
        query.setParameter("id", id);
        List<DaysOfWeek> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public List<LessonTime> findAllLessonTime() {

            Query query = createQuery("from LessonTime");
            List<LessonTime> listOfLessons = query.list();
            if(listOfLessons==null)
                return Collections.emptyList();
            return  listOfLessons;
        }

    @Override
    public List<TimeTable> findTimeTableByIdClass(Long id) {
        Query query = createQuery("select tt from TimeTable tt, Class c, TeacherSubjectClass tsc where tsc.aClass=c.idclass and c.idclass=:id and tt.teacherSubjectClass=tsc.id");
        query.setParameter("id",id);
        List<TimeTable> listOfTimeTable = query.list();
        if(listOfTimeTable==null)
            return Collections.emptyList();
        return  listOfTimeTable;
    }

    @Override
    public List<TimeTable> findTimeTableByIdTeacher(Long id) {
        Query query = createQuery("select tt from TimeTable tt, Teacher t, TeacherSubjectClass tsc where tsc.teacher=t.idTeacher and t.idTeacher=:id and tt.teacherSubjectClass=tsc.id");
        query.setParameter("id",id);
        List<TimeTable> listOfTimeTable = query.list();
        if(listOfTimeTable==null)
            return Collections.emptyList();
        return  listOfTimeTable;
    }

    @Override
    public TimeTable findTimeTableByIdClassAndIdLessonTimeAndIdDayOfWeek(Long idClass, Long idLesson, Long idDay) {
        Query query = createQuery("SELECT  tt FROM TimeTable tt, LessonTime lt, DaysOfWeek dow, Class c, TeacherSubjectClass tsc where tt.lessonTime = lt.id and tt.daysOfWeek = dow.id and tt.teacherSubjectClass=tsc.id and tsc.aClass=c.idclass and " +
                "lt.id=:idLesson and dow.id=:idDay and c.idclass=:idClass");
        query.setParameter("idLesson",idLesson);
        query.setParameter("idDay",idDay);
        query.setParameter("idClass",idClass);
        return (TimeTable) query.uniqueResult();
    }

    @Override
    public void addTimeTable(TimeTable timeTable) {
persist(timeTable);
    }

    @Override
    public void deleteTimeTable(TimeTable timeTable) {
delete(timeTable);
    }

}




