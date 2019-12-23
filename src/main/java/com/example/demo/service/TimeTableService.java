package com.example.demo.service;

import com.example.demo.domain.DaysOfWeek;
import com.example.demo.domain.LessonTime;
import com.example.demo.domain.TeacherSubjectClass;
import com.example.demo.domain.TimeTable;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

public interface TimeTableService {
    ArrayList<Date> findAllDatesForLesson(Long idTSC);
    ArrayList<Date> findAllDatesForLessonBeforeToday(Long idTSC);
    ArrayList<ArrayList<Date>> findAllDatesForLessonBeforeToday(ArrayList<TeacherSubjectClass>tsc);
    ArrayList<Date> findAllDatesInWeek(Date date);
    ArrayList< ArrayList<Date> >findAllDatesForFourWeeks(Date date);
    List<DaysOfWeek> findAll();
    List<LessonTime> findAllLessonTime();
    List<TimeTable> findTimeTableByIdClass(Long id);
    List<TimeTable> findTimeTableByIdTeacher(Long id);
    void saveTimeTable(ArrayList<TeacherSubjectClass> tscList,Long idClass);
    Date findNextDateForLessonByIdTSCAndDate(Long id,Date today);
    Date findPrevDateForLessonByIdTSCAndDate(Long id,Date today);
    void deleteByTSC(List<TeacherSubjectClass> tsc);
    void deleteByTSC(TeacherSubjectClass tsc);
    void deleteTimeTable(TimeTable timeTable);

}
