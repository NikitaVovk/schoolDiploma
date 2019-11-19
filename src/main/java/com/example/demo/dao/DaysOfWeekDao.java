package com.example.demo.dao;

import com.example.demo.domain.DaysOfWeek;

import java.util.ArrayList;
import java.util.List;

public interface DaysOfWeekDao {
    List<DaysOfWeek> findAll();
    DaysOfWeek findById(Long id);
}
