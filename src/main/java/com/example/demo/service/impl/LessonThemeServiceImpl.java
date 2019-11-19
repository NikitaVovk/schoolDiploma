package com.example.demo.service.impl;

import com.example.demo.dao.LessonThemeDao;
import com.example.demo.domain.HomeWork;
import com.example.demo.domain.LessonTheme;
import com.example.demo.service.LessonThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service("lessonThemeService")
@Transactional
public class LessonThemeServiceImpl implements LessonThemeService {
    @Autowired
    private LessonThemeDao lessonThemeDao;

    @Override
    public LessonTheme findLessonThemeByIdTscAndDate(Long idTSC, Date date) {
        return lessonThemeDao.findLessonThemeByIdTscAndDate(idTSC,date);
    }

    @Override
    public void addLessonTheme(LessonTheme lessonTheme) {
        LessonTheme lt = this.findLessonThemeByIdTscAndDate(lessonTheme.getTsc().getId(),new Date(lessonTheme.getDate().getTime()-86400000L));
        if (lt!=null){
            lessonThemeDao.deleteLessonTheme(lt);
            lessonThemeDao.addLessonTheme(lessonTheme);
        }
        else
            lessonThemeDao.addLessonTheme(lessonTheme);
    }
}
