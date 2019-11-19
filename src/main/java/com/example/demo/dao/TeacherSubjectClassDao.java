package com.example.demo.dao;

import com.example.demo.domain.Class;
import com.example.demo.domain.Subject;
import com.example.demo.domain.Teacher;
import com.example.demo.domain.TeacherSubjectClass;

import java.util.List;

public interface TeacherSubjectClassDao {
    List<Class> findClassesByIdTeacher(Long id);
    List<Subject>  findSubjectsByIdTeacher(Long idTeacher);
    List<Teacher> findTeacherByIdClass(Long id);
    List<TeacherSubjectClass>findTSCByIdTeacher(Long id);
    List<TeacherSubjectClass>findTSCByIdClass(Long id);
    TeacherSubjectClass findTSCByIdTSC(Long idTSC);
    TeacherSubjectClass findTSCByIdClassAndIdSubject(Long idClass,Long idSubject);
    void addTSC(TeacherSubjectClass tsc);
    void deleteTSC(TeacherSubjectClass tsc);

}
