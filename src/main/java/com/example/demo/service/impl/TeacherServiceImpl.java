package com.example.demo.service.impl;

import com.example.demo.dao.TeacherDao;
import com.example.demo.domain.Student;
import com.example.demo.domain.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Override
    public List<Teacher> findTeacherByName(String teacherName) {
        return teacherDao.findTeacherByName(teacherName);
    }

    @Override
    public Teacher findTeacherByIdTeacher(Long id) {
        return teacherDao.findTeacherByIdTeacher(id);
    }

    @Override
    public Teacher findTeacherByIdAccount(Long id) {
        return teacherDao.findTeacherByIdAccount(id);
    }

    @Override
    public List<Teacher> findTeacherBySurName(String teacherSurName) {
        return teacherDao.findTeacherBySurName(teacherSurName);
    }

    @Override
    public List<Teacher> findTeacherBySurNameAndName(String teacherSurName, String teacherName) {
        return teacherDao.findTeacherBySurNameAndName(teacherSurName,teacherName);
    }

    @Override
    public List<Teacher> findStudentsByIdClass(Long id) {
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public PagedListHolder<Teacher> findAll(int size, int page) {
        PagedListHolder<Teacher> pagedListHolder= new PagedListHolder<>(teacherDao.findAll());
        pagedListHolder.setPageSize(size);
        pagedListHolder.setPage(page);
        // Page<Student> page = new PageImpl<>(studentDao.findAll(),pageRequest,studentDao.findAll().size());
        return pagedListHolder;
    }

    @Override
    public PagedListHolder<Teacher> findTeacherByName(String teacherName, int size, int page) {
        PagedListHolder<Teacher> pagedListHolder= new PagedListHolder<>(teacherDao.findTeacherByName(teacherName));
        pagedListHolder.setPageSize(size);
        pagedListHolder.setPage(page);
        // Page<Student> page = new PageImpl<>(studentDao.findAll(),pageRequest,studentDao.findAll().size());
        return pagedListHolder;
    }

    @Override
    public PagedListHolder<Teacher> findTeacherBySurName(String teacherSurName, int size, int page) {
        PagedListHolder<Teacher> pagedListHolder= new PagedListHolder<>(teacherDao.findTeacherBySurName(teacherSurName));
        pagedListHolder.setPageSize(size);
        pagedListHolder.setPage(page);
        // Page<Student> page = new PageImpl<>(studentDao.findAll(),pageRequest,studentDao.findAll().size());
        return pagedListHolder;
    }

    @Override
    public PagedListHolder<Teacher> findTeacherBySurNameAndName(String teacherSurName, String teacherName, int size, int page) {
        PagedListHolder<Teacher> pagedListHolder= new PagedListHolder<>(teacherDao.findTeacherBySurNameAndName(teacherSurName,teacherName));
        pagedListHolder.setPageSize(size);
        pagedListHolder.setPage(page);
        // Page<Student> page = new PageImpl<>(studentDao.findAll(),pageRequest,studentDao.findAll().size());
        return pagedListHolder;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
teacherDao.deleteTeacher(teacher);
    }
}
