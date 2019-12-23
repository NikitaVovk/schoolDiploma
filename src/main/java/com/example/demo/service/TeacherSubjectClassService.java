package com.example.demo.service;

import com.example.demo.domain.Class;
import com.example.demo.domain.Subject;
import com.example.demo.domain.Teacher;
import com.example.demo.domain.TeacherSubjectClass;

import java.util.ArrayList;
import java.util.List;

public interface TeacherSubjectClassService {
    List<Class> findClassesByIdTeacher(Long idTeacher);
    List<Subject>  findSubjectsByIdTeacher(Long idTeacher);
    List<TeacherSubjectClass>findTSCByIdTeacher(Long id);
    List<Teacher> findTeacherByIdClass(Long id);
    TeacherSubjectClass findTSCByIdTSC(Long idTSC);
    List<TeacherSubjectClass>findTSCByIdClass(Long id);
    List<TeacherSubjectClass>findTSCByIdSubject(Long id);

    TeacherSubjectClass findTSCByIdClassAndIdSubject(Long idClass,Long idSubject);
    ArrayList<TeacherSubjectClass> findTSCByIdClassAndIdSubject(Long idClass, List<Subject> subjects);
    void addTSC(TeacherSubjectClass tsc);
    void deleteTSC(TeacherSubjectClass tsc);
    void deleteByTeacher(Long id);
    void deleteByClass(Long id);
    void deleteBySubject(Long id);
}
