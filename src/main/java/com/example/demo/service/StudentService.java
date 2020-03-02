package com.example.demo.service;

import com.example.demo.domain.Student;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    List<Student> findStudentByName(String studentName);
    List<Student> findStudentBySurName(String studentSurName);
    List<Student> findStudentBySurNameAndName(String studentSurName,String studentName);
    Student findStudentByIdStudent(Long id);
    Student findStudentByIdAccount(Long id);
    List<Student> findStudentsByIdClass(Long id);
    List<Student> findAll();
    PagedListHolder<Student> findAllPages(int size, int page);
    PagedListHolder<Student> findStudentsByIdClassPages(Long id,int size, int page);
    PagedListHolder<Student> findStudentByName(String studentName,int size, int page);
    PagedListHolder<Student> findStudentBySurName(String studentSurName,int size, int page);
    PagedListHolder<Student> findStudentBySurNameAndName(String studentSurName,String studentName,int size, int page);
    void addStudent(Student student);
    void editStudent(Student student);
    void deleteStudent(Student student);
    void deleteClassInStudents(Long id);
}
