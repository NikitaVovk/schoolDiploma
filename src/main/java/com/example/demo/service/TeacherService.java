package com.example.demo.service;

import com.example.demo.domain.Teacher;
import org.springframework.beans.support.PagedListHolder;

import java.util.List;

public interface TeacherService {
    List<Teacher> findTeacherByName(String teacherName);
    Teacher findTeacherByIdTeacher(Long id);
    Teacher findTeacherByIdAccount(Long id);

    List<Teacher> findTeacherBySurName(String teacherSurName);
    List<Teacher> findTeacherBySurNameAndName(String teacherSurName,String teacherName);
    List<Teacher> findStudentsByIdClass(Long id);
    List<Teacher> findAll();

    PagedListHolder<Teacher> findAll(int size, int page);
    PagedListHolder<Teacher> findTeacherByName(String teacherName,int size, int page);
    PagedListHolder<Teacher> findTeacherBySurName(String teacherSurName,int size, int page);
    PagedListHolder<Teacher> findTeacherBySurNameAndName(String teacherSurName,String teacherName,int size, int page);
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
}
