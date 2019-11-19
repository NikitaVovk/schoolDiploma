package com.example.demo.service;

import com.example.demo.domain.Marks;
import com.example.demo.domain.Student;
import com.example.demo.domain.Subject;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface MarksService {
    ArrayList<List<Marks>> findMarksByIdStudentAndIdSubject(List<Student> students, Long idSubject);
    ArrayList<List<Marks>> findMarksByIdStudentAndIdSubject(Student student, List<Subject>subjects);
    ArrayList<List<Marks>> findMarksByIdStudentAndDates(Long idStudent, List<Date> dates);

    List<Marks> findMarksByIdStudentAndIdSubject(Long idStudent, Long idSubject);
    ArrayList<Marks> findMarksByIdStudentAndIdSubjectAndDate(List<Student> students, Long idSubject, java.sql.Date date);
    Marks findMarkByIdMark(Long idMark);
    ArrayList<Marks> addMarks(List<Student>students, Subject subject, Date date, ArrayList<String> mark);

}
