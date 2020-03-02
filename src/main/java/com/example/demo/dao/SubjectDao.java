package com.example.demo.dao;

import com.example.demo.domain.Class;
import com.example.demo.domain.Subject;

import java.util.List;

public interface SubjectDao {
    Subject findSubjectByName(String subjectName);
    Subject findSubjectByIdSubject(Long id);
    List<Subject> findSubjectsByIdClass(Long id);
    List<Subject> findAll();
    void addSubject (Subject subject);
    void deleteSubject(Subject subject);
}
