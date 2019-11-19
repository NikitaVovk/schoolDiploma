package com.example.demo.dao;

import com.example.demo.domain.Marks;
import com.example.demo.domain.Student;
import com.example.demo.domain.TeacherSubjectClass;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface MarksDao {
    List<Marks> findMarksByIdStudentAndIdSubject(Long idStudent, Long idSubject);
    List<Marks> findMarksByIdStudentAndDate(Long idStudent, Date date);
    Marks findMarksByIdStudentAndIdSubjectAndDate(Long idStudent, Long idSubject, java.sql.Date date);
    Marks findMarkByIdMark(Long idMark);
    void addMarks(Marks marks);
    void deleteMarks(Marks marks);
    void updateMarks(Marks marks);
}
