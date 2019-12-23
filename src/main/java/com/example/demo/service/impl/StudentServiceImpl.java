package com.example.demo.service.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PagedListHolder<Student> findAllPages(int size, int page) {
        //PageRequest pageRequest = new PageRequest(1,10);
        PagedListHolder<Student> pagedListHolder= new PagedListHolder<>(studentDao.findAll());
        pagedListHolder.setPageSize(size);
        pagedListHolder.setPage(page);
       // Page<Student> page = new PageImpl<>(studentDao.findAll(),pageRequest,studentDao.findAll().size());
        return pagedListHolder;
    }

    @Override
    public PagedListHolder<Student> findStudentsByIdClassPages(Long id,int size, int page) {
        PagedListHolder<Student> pagedListHolder= new PagedListHolder<>(studentDao.findStudentsByIdClass(id));
        pagedListHolder.setPageSize(size);
        pagedListHolder.setPage(page);
        // Page<Student> page = new PageImpl<>(studentDao.findAll(),pageRequest,studentDao.findAll().size());
        return pagedListHolder;
    }

    @Override
    public PagedListHolder<Student> findStudentByName(String studentName, int size, int page) {
        PagedListHolder<Student> pagedListHolder= new PagedListHolder<>(studentDao.findStudentByName(studentName));
        pagedListHolder.setPageSize(size);
        pagedListHolder.setPage(page);
        // Page<Student> page = new PageImpl<>(studentDao.findAll(),pageRequest,studentDao.findAll().size());
        return pagedListHolder;
    }

    @Override
    public PagedListHolder<Student> findStudentBySurName(String studentSurName, int size, int page) {
        PagedListHolder<Student> pagedListHolder= new PagedListHolder<>(studentDao.findStudentBySurName(studentSurName));
        pagedListHolder.setPageSize(size);
        pagedListHolder.setPage(page);
        // Page<Student> page = new PageImpl<>(studentDao.findAll(),pageRequest,studentDao.findAll().size());
        return pagedListHolder;
    }

    @Override
    public PagedListHolder<Student> findStudentBySurNameAndName(String studentSurName, String studentName, int size, int page) {
        PagedListHolder<Student> pagedListHolder= new PagedListHolder<>(studentDao.findStudentBySurNameAndName(studentSurName,studentName));
        pagedListHolder.setPageSize(size);
        pagedListHolder.setPage(page);
        // Page<Student> page = new PageImpl<>(studentDao.findAll(),pageRequest,studentDao.findAll().size());
        return pagedListHolder;
    }

    @Override
    public void addStudent(Student student) {
studentDao.addStudent(student);
    }

    @Override
    public void editStudent(Student student) {
studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteStudent(student);
    }

    @Override
    public void deleteClassInStudents(Long id) {
        List <Student> students = studentDao.findStudentsByIdClass(id);
        for (Student s: students) {
            s.setaClass(null);
            this.editStudent(s);
        }
    }
}
