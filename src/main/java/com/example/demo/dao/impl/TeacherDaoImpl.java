package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.TeacherDao;
import com.example.demo.domain.Class;
import com.example.demo.domain.Student;
import com.example.demo.domain.Teacher;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Transactional
@Repository("teacherDao")
public class TeacherDaoImpl extends AbstractDao<Long, Teacher> implements TeacherDao {

    @Override
    public  List<Teacher> findTeacherByName(String teacherName) {
        Query query = createQuery("FROM Teacher t  where  t.name=:name order by t.name");
        query.setParameter("name", teacherName);
        List<Teacher> listOfTeachers = query.list();
        if(listOfTeachers==null)
            return Collections.emptyList();
        return  listOfTeachers;
    }

    @Override
    public Teacher findTeacherByIdTeacher(Long id) {
        return getByKey(id);
    }

    @Override
    public Teacher findTeacherByIdAccount(Long id) {
//        Query query = createQuery("from Teacher e, Account a where e.account = a.idaccount and a.idaccount =:id");
        Query query = createQuery("select e from Teacher e, Account a where e.account = a.idaccount and a.idaccount =:id");
        query.setParameter("id", id);
        return (Teacher) query.uniqueResult();
    }

    @Override
    public List<Teacher> findTeacherBySurName(String teacherSurName) {
        Query query = createQuery("FROM Teacher t  where  t.surname=:surname order by t.surname");
        query.setParameter("surname", teacherSurName);
        List<Teacher> listOfTeachers = query.list();
        if(listOfTeachers==null)
            return Collections.emptyList();
        return  listOfTeachers;
    }

    @Override
    public List<Teacher> findTeacherBySurNameAndName(String teacherSurName, String teacherName) {
        Query query = createQuery("FROM Teacher t  where  t.surname=:surname and t.name=:name  order by t.surname");
        query.setParameter("surname", teacherSurName);
        query.setParameter("name", teacherName);
        List<Teacher> listOfTeachers = query.list();
        if(listOfTeachers==null)
            return Collections.emptyList();
        return  listOfTeachers;
    }

    @Override
    public List<Teacher> findStudentsByIdClass(Long id) {
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        Query query = createQuery("FROM Teacher t order by t.surname");

        List<Teacher> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        persist(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        update(teacher);
    }
}
