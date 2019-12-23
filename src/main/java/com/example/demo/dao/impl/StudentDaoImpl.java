package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dao.SubjectDao;
import com.example.demo.domain.Student;
import com.example.demo.domain.Subject;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Transactional
@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Long, Student> implements StudentDao {
    @Override
    public List<Student>findStudentByName(String studentName) {
        Query query = createQuery("FROM Student s  where  s.name=:name order by s.name");
        query.setParameter("name", studentName);
        List<Student> listOfStudents = query.list();
        if(listOfStudents==null)
            return Collections.emptyList();
        return  listOfStudents;
    }

    @Override
    public List<Student> findStudentBySurName(String studentSurName) {
        Query query = createQuery("FROM Student s  where  s.surname=:surname order by s.surname");
        query.setParameter("surname", studentSurName);
        List<Student> listOfStudents = query.list();
        if(listOfStudents==null)
            return Collections.emptyList();
        return  listOfStudents;
    }

    @Override
    public List<Student> findStudentBySurNameAndName(String studentSurName, String studentName) {
        Query query = createQuery("FROM Student s  where  s.surname=:surname and s.name=:name  order by s.surname");
        query.setParameter("surname", studentSurName);
        query.setParameter("name", studentName);
        List<Student> listOfStudents = query.list();
        if(listOfStudents==null)
            return Collections.emptyList();
        return  listOfStudents;
    }

    @Override
    public Student findStudentByIdStudent(Long id) {
        return getByKey(id);
    }

    @Override
    public Student findStudentByIdAccount(Long id) {
        Query query = createQuery("select s from Student s, Account a where s.account = a.idaccount and a.idaccount =:id");
        query.setParameter("id", id);
        return (Student) query.uniqueResult();
    }

    @Override
    public List<Student> findStudentsByIdClass(Long id) {
        Query query = createQuery("SELECT  s FROM Student s , Class c where s.aClass=c.idclass and c.idclass=:id order by s.surname");
        query.setParameter("id", id);
        List<Student> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public List<Student> findAll() {
        Query query = createQuery("FROM Student s order by s.surname");

        List<Student> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public void addStudent(Student student) {
        persist(student);
    }

    @Override
    public void updateStudent(Student student) {
    update(student);
    }

    @Override
    public void deleteStudent(Student student) {
delete(student);
    }
}