package com.example.demo.service;

import com.example.demo.domain.Class;

import java.util.List;

public interface ClassService {
    List<Class> findAll();
    Class findClassByIdClass(Long id);
    void addClass(Class cl);
    void deleteClass(Class cl);

}
