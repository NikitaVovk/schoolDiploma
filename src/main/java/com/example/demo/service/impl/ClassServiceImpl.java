package com.example.demo.service.impl;

import com.example.demo.dao.ClassDao;
import com.example.demo.domain.Class;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("classService")
@Transactional
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;
    @Override
    public List<Class> findAll() {
        return classDao.findAll();
    }

    @Override
    public Class findClassByIdClass(Long id) {
       return classDao.findClassByIdClass(id);
    }

    @Override
    public void addClass(Class cl) {
    classDao.addClass(cl);
    }

    @Override
    public void deleteClass(Class cl) {
classDao.deleteClass(cl);
    }
}
