package com.example.demo.service.impl;

import com.example.demo.dao.TestDao;
import com.example.demo.domain.Test;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> findTestByIdTSC(Long idTSC) {
        return testDao.findTestByIdTSC(idTSC);
    }

    @Override
    public Test findTestByIdTSCAndDate(Long idTSC, Date date) {
        return testDao.findTestByIdTSCAndDate(idTSC,date);
    }

    @Override
    public List<Test> findTestByIdClassAndBetweenDates(Long idClass, Date date1, Date date2) {
        return testDao.findTestByIdClassAndBetweenDates(idClass,date1,date2);
    }

//    @Override
//    public ArrayList<ArrayList<Test>> findListOfTestByDateList(Long idTSC, ArrayList<ArrayList<Date>> dates) {
//        ArrayList<ArrayList<Test>> tests = new ArrayList<>();
//        for (ArrayList<Date> dateArrayList:dates) {
//            ArrayList<Test>testArrayList= new ArrayList<>();
//            for (Date d:dateArrayList) {
//                testArrayList.add(this.findTestByIdTSCAndDate(idTSC,d));
//            }
//            tests.add(testArrayList);
//        }
//        return tests;
//    }

    @Override
    public void addTest(Test test) {
        Test testOb=this.findTestByIdTSCAndDate(test.getTsc().getId(),new Date(test.getDate().getTime()-86400000L));
        if (testOb!=null){
            testDao.deleteTest(testOb);
            testDao.addTest(test);
        }
else
        testDao.addTest(test);
    }

    @Override
    public void deleteTest(Test test) {
testDao.deleteTest(test);
    }
}
