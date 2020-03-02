package com.example.demo.service;

import com.example.demo.domain.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findSubjectsByIdClass(Long id);
    List<Subject> findAll();
    Subject findSubjectByIdSubject(Long id);

    void addSubject (Subject subject);
    void deleteSubject(Subject subject);

}
