package com.example.demo.service.impl;

import com.example.demo.dao.TeacherSubjectClassDao;
import com.example.demo.domain.Class;
import com.example.demo.domain.Subject;
import com.example.demo.domain.Teacher;
import com.example.demo.domain.TeacherSubjectClass;
import com.example.demo.service.TeacherSubjectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("teacherSubjectClassService")
@Transactional
public class TeacherSubjectClassServiceImpl implements TeacherSubjectClassService {
    @Autowired
    private TeacherSubjectClassDao teacherSubjectClassDao;

    @Override
    public List<Class> findClassesByIdTeacher(Long idTeacher) {
        return teacherSubjectClassDao.findClassesByIdTeacher(idTeacher);
    }

    @Override
    public List<Subject> findSubjectsByIdTeacher(Long idTeacher) {
        return teacherSubjectClassDao.findSubjectsByIdTeacher(idTeacher);
    }

    @Override
    public List<TeacherSubjectClass> findTSCByIdTeacher(Long id) {
        return teacherSubjectClassDao.findTSCByIdTeacher(id);
    }

    @Override
    public List<Teacher> findTeacherByIdClass(Long id) {
        return teacherSubjectClassDao.findTeacherByIdClass(id);
    }

    @Override
    public TeacherSubjectClass findTSCByIdTSC(Long idTSC) {
        return teacherSubjectClassDao.findTSCByIdTSC(idTSC);
    }

    @Override
    public List<TeacherSubjectClass> findTSCByIdClass(Long id) {
        return teacherSubjectClassDao.findTSCByIdClass(id);
    }

    @Override
    public List<TeacherSubjectClass> findTSCByIdSubject(Long id) {
        return  teacherSubjectClassDao.findTSCByIdSubject(id);
    }

    @Override
    public TeacherSubjectClass findTSCByIdClassAndIdSubject(Long idClass, Long idSubject) {
        return teacherSubjectClassDao.findTSCByIdClassAndIdSubject(idClass,idSubject);
    }

    @Override
    public ArrayList<TeacherSubjectClass> findTSCByIdClassAndIdSubject(Long idClass, List<Subject> subjects) {
        ArrayList<TeacherSubjectClass> tsc = new ArrayList<>();
        for (Subject s :subjects){
           tsc.add(this.findTSCByIdClassAndIdSubject(idClass,s.getIdsubject()));
        }
        return tsc;
    }

    @Override
    public void addTSC(TeacherSubjectClass tsc) {
teacherSubjectClassDao.addTSC(tsc);
    }

    @Override
    public void deleteTSC(TeacherSubjectClass tsc) {
teacherSubjectClassDao.deleteTSC(tsc);
    }

    @Override
    public void deleteByTeacher(Long id) {
       List<TeacherSubjectClass>  tsc =teacherSubjectClassDao.findTSCByIdTeacher(id);
        for (TeacherSubjectClass itemTSC:tsc) {
            this.deleteTSC(itemTSC);
        }
    }

    @Override
    public void deleteByClass(Long id) {
        List<TeacherSubjectClass>  tsc =teacherSubjectClassDao.findTSCByIdClass(id);
        for (TeacherSubjectClass itemTSC:tsc) {
            this.deleteTSC(itemTSC);
        }
    }

    @Override
    public void deleteBySubject(Long id) {
        List<TeacherSubjectClass>  tsc =teacherSubjectClassDao.findTSCByIdSubject(id);
        for (TeacherSubjectClass itemTSC:tsc) {
            this.deleteTSC(itemTSC);
        }
    }
}
