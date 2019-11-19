package com.example.demo.service.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;


    @Override
    public List<Student> findStudentByName(String studentName) {
        return studentDao.findStudentByName(studentName);
    }

    @Override
    public List<Student> findStudentBySurName(String studentSurName) {
        return studentDao.findStudentBySurName(studentSurName);
    }

    @Override
    public List<Student> findStudentBySurNameAndName(String studentSurName, String studentName) {
        return studentDao.findStudentBySurNameAndName(studentSurName,studentName);
    }

    @Override
    public Student findStudentByIdStudent(Long id) {
        return studentDao.findStudentByIdStudent(id);
    }

    @Override
    public Student findStudentByIdAccount(Long id) {
       return studentDao.findStudentByIdAccount(id);
    }

    @Override
    public List<Student> findStudentsByIdClass(Long id) {
        return studentDao.findStudentsByIdClass(id);
    }

    @Override
    public List<Student> findAll() {
        return  studentDao.findAll();
    }

    @Override
    public void addStudent(Student student) {
studentDao.addStudent(student);
    }

    @Override
    public void editStudent(Student student) {
studentDao.updateStudent(student);
    }
}
