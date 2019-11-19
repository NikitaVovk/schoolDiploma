package com.example.demo.dao;

import com.example.demo.domain.HomeWork;
import com.example.demo.domain.Marks;

import java.sql.Date;

public interface HomeWorkDao {


    HomeWork findHomeWorkByIdTscAndDateAdded(Long idTSC, Date date);
    HomeWork findHomeWorkByIdTscAndDateDue(Long idTSC, Date date);
    void addHomeWork(HomeWork homeWork);
    void deleteHomeWork(HomeWork homeWork);
    void updateHomeWork(HomeWork homeWork);
}
