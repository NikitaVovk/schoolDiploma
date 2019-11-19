package com.example.demo.service.impl;


import com.example.demo.dao.HomeWorkDao;
import com.example.demo.domain.HomeWork;
import com.example.demo.domain.TeacherSubjectClass;
import com.example.demo.service.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service("homeWorkService")
@Transactional
public class HomeWorkServiceImpl implements HomeWorkService {

    @Autowired
    private HomeWorkDao homeWorkDao;
    @Override
    public void addHomework(HomeWork homeWork) {
        HomeWork hw = this.findHomeWorkByIdTscAndDateAdded(homeWork.getTsc().getId(),new Date(homeWork.getDateAdded().getTime()-86400000L));
        if (hw!=null){
            homeWorkDao.deleteHomeWork(hw);
            homeWorkDao.addHomeWork(homeWork);
        }
        else
            homeWorkDao.addHomeWork(homeWork);
    }

    @Override
    public HomeWork findHomeWorkByIdTscAndDateAdded(Long idTSC, Date date) {
        return homeWorkDao.findHomeWorkByIdTscAndDateAdded(idTSC,date);
    }

    @Override
    public ArrayList<HomeWork> findHomeWorkByIdTscAndDatesDue(List<TeacherSubjectClass> idTSC, List<Date> dates) {
        ArrayList<HomeWork> homeWorkArrayList = new ArrayList<>();
        for (TeacherSubjectClass tsc:idTSC){
            for (Date d :dates){
                HomeWork homeWork=homeWorkDao.findHomeWorkByIdTscAndDateDue(tsc.getId(),d);
                if (homeWork!=null)
                    homeWorkArrayList.add(homeWork);
            }
        }
        return homeWorkArrayList;
    }
}
