package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.DaysOfWeekDao;
import com.example.demo.dao.LessonTimeDao;
import com.example.demo.domain.DaysOfWeek;
import com.example.demo.domain.LessonTime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("lessonTimeDaoImpl")
public class LessonTimeDaoImpl extends AbstractDao<Long, LessonTime> implements LessonTimeDao {

    @Override
    public LessonTime findById(Long id) {
        return getByKey(id);
    }
}


