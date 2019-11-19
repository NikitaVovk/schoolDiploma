package com.example.demo.service;

import com.example.demo.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> findStudentByName(String studentName);
    List<Student> findStudentBySurName(String studentSurName);
    List<Student> findStudentBySurNameAndName(String studentSurName,String studentName);
    Student findStudentByIdStudent(Long id);
    Student findStudentByIdAccount(Long id);
    List<Student> findStudentsByIdClass(Long id);
    List<Student> findAll();
    void addStudent(Student student);
    void editStudent(Student student);
}
