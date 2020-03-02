package com.example.demo.dao;

import com.example.demo.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findStudentByName(String studentName);
    List<Student> findStudentBySurName(String studentSurName);
    List<Student> findStudentBySurNameAndName(String studentSurName,String studentName);
    Student findStudentByIdStudent(Long id);
    Student findStudentByIdAccount(Long id);
    List<Student> findStudentsByIdClass(Long id);
    List<Student> findAll();
    void addStudent(Student student);
    void updateStudent(Student student);
    void  deleteStudent(Student student);

}
