package com.example.demo.dao;

import com.example.demo.domain.Class;

import java.util.List;

public interface ClassDao {
    Class findClassByName(String className);
    Class findClassByIdClass(Long id);
    List<Class> findAll();
    void addClass(Class cl);
}
