package com.example.demo.service.impl;


import com.example.demo.dao.SubjectDao;
import com.example.demo.domain.Subject;
import com.example.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;


    @Override
    public List<Subject> findSubjectsByIdClass(Long id) {
        return subjectDao.findSubjectsByIdClass(id);
    }

    @Override
    public List<Subject> findAll() {
       return subjectDao.findAll();
    }

    @Override
    public Subject findSubjectByIdSubject(Long id) {
        return subjectDao.findSubjectByIdSubject(id);
    }

    @Override
    public void addSubject(Subject subject) {
        subjectDao.addSubject(subject);
    }
}
