package com.example.demo.service;

import com.example.demo.domain.Frequency;
import com.example.demo.domain.Marks;
import com.example.demo.domain.Student;
import com.example.demo.domain.Subject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface FrequencyService {
    ArrayList<List<Frequency>> findFrequencyByIdStudentAndIdSubject(List<Student> students, Long idSubject);
    ArrayList<List<Frequency>> findFrequencyByIdStudentAndIdSubject(Student student, List<Subject>subjects);
    ArrayList<Float>findProcentFrequency(ArrayList<ArrayList<Date>>dates,ArrayList<List<Frequency>>freqs);
    ArrayList<Float>findProcentFrequencyForTsc(ArrayList<Date>dates,ArrayList<List<Frequency>>freqs);

    ArrayList<List<Frequency>> findFrequencyByIdStudentAndDates(Long idStudent, List<Date> dates);

    List<Frequency> findFrequencyByIdStudentAndIdSubject(Long idStudent, Long idSubject);
    ArrayList<Frequency> findFrequencyByIdStudentAndIdSubjectAndDate(List<Student> students, Long idSubject, java.sql.Date date);
    Frequency findFrequencyByIdMark(Long id);
    ArrayList<Frequency> addFrequency(List<Student>students, Subject subject, Date date, List<String> freq);
}
