package com.example.demo.dao;

import com.example.demo.domain.HomeWork;
import com.example.demo.domain.LessonTheme;

import java.sql.Date;

public interface LessonThemeDao {
    LessonTheme findLessonThemeByIdTscAndDate(Long idTSC, Date date);
    void addLessonTheme(LessonTheme lessonTheme);
    void deleteLessonTheme(LessonTheme lessonTheme);
    void updateLessonTheme(LessonTheme lessonTheme);

}
