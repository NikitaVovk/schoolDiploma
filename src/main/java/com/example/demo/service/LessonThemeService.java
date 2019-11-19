package com.example.demo.service;

import com.example.demo.domain.LessonTheme;

import java.sql.Date;

public interface LessonThemeService {
    LessonTheme findLessonThemeByIdTscAndDate(Long idTSC, Date date);

    void addLessonTheme(LessonTheme lessonTheme);
}
