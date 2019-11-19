package com.example.demo.dao;

import com.example.demo.domain.Subject;
import com.example.demo.domain.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> findTeacherByName(String teacherName);
    Teacher findTeacherByIdTeacher(Long id);
    Teacher findTeacherByIdAccount(Long id);

    List<Teacher> findTeacherBySurName(String teacherSurName);
    List<Teacher> findTeacherBySurNameAndName(String teacherSurName,String teacherName);
    List<Teacher> findStudentsByIdClass(Long id);
    List<Teacher> findAll();
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);

}
