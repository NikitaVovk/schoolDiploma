package com.example.demo.dao;

import com.example.demo.domain.DaysOfWeek;
import com.example.demo.domain.LessonTime;
import com.example.demo.domain.TimeTable;

import java.util.ArrayList;
import java.util.List;

public interface TimeTableDao {
    List<DaysOfWeek> findDaysByIdTSC(Long id);
    List<LessonTime> findAllLessonTime();
    List<TimeTable> findTimeTableByIdClass(Long id);
    List<TimeTable> findTimeTableByIdTeacher(Long id);
    List<TimeTable> findTimeTableByIdTSC(Long id);
    TimeTable findTimeTableByIdClassAndIdLessonTimeAndIdDayOfWeek(Long idClass,Long idLesson,Long idDay);
    void addTimeTable(TimeTable timeTable);
    void deleteTimeTable(TimeTable timeTable);

}
