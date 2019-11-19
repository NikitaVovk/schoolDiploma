package com.example.demo.dao;

import com.example.demo.domain.Frequency;
import com.example.demo.domain.Marks;

import java.sql.Date;
import java.util.List;

public interface FrequencyDao {
        List<Frequency> findFrequencyByIdStudentAndIdSubject(Long idStudent, Long idSubject);
        List<Frequency> findFrequencyByIdStudentAndDate(Long idStudent, Date date);
    Frequency findFrequencyByIdStudentAndIdSubjectAndDate(Long idStudent, Long idSubject, java.sql.Date date);
    Frequency findFrequencyByIdMark(Long idFrequency);
        void addFrequency(Frequency frequency);
        void deleteFrequency(Frequency frequency);
        void updateFrequency(Frequency frequency);

}
