package com.example.demo.service;

import com.example.demo.domain.HomeWork;
import com.example.demo.domain.TeacherSubjectClass;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface HomeWorkService {
    void addHomework(HomeWork homeWork);
    HomeWork findHomeWorkByIdTscAndDateAdded(Long idTSC, Date date);
    ArrayList<HomeWork>findHomeWorkByIdTscAndDatesDue(List<TeacherSubjectClass>idTSC, List<Date>dates);
}
