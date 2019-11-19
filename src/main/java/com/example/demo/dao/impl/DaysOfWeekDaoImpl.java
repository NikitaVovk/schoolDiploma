package com.example.demo.dao.impl;


import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.DaysOfWeekDao;
import com.example.demo.domain.DaysOfWeek;
import com.example.demo.domain.Marks;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository("daysOfWeekDaoDao")
public class DaysOfWeekDaoImpl extends AbstractDao<Long, DaysOfWeek> implements DaysOfWeekDao {

    @Override
    public List<DaysOfWeek> findAll() {
        Query query = createQuery("from DaysOfWeek");
        List<DaysOfWeek> listOfDays = query.list();
        if(listOfDays==null)
            return Collections.emptyList();
        return  listOfDays;
    }

    @Override
    public DaysOfWeek findById(Long id) {
        return getByKey(id);
    }
}
