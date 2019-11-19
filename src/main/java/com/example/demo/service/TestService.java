package com.example.demo.service;

import com.example.demo.domain.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface TestService {
    List<Test> findTestByIdTSC(Long idTSC);
    Test findTestByIdTSCAndDate(Long idTSC, Date date);
   // ArrayList<ArrayList<Test>> findListOfTestByDateList(Long idTSC, ArrayList<ArrayList<Date>> dates);
   List<Test> findTestByIdClassAndBetweenDates(Long idClass,Date date1,Date date2);

    void addTest(Test test);
    void deleteTest(Test test);
}
