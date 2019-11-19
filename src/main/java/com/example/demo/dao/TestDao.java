package com.example.demo.dao;

import com.example.demo.domain.HomeWork;
import com.example.demo.domain.Test;

import java.sql.Date;
import java.util.List;

public interface TestDao {

    List<Test> findTestByIdTSC(Long idTSC);
    Test findTestByIdTSCAndDate(Long idTSC,Date date);
    List<Test> findTestByIdClassAndBetweenDates(Long idClass,Date date1,Date date2);
    void addTest(Test test);
    void deleteTest(Test test);
    void updateTest(Test test);
}
