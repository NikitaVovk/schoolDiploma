package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.ClassDao;
import com.example.demo.dao.SubjectDao;
import com.example.demo.domain.Class;
import com.example.demo.domain.Student;
import com.example.demo.domain.Subject;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Transactional
@Repository("subjectDao")
public class SubjectDaoImpl extends AbstractDao<Long, Subject> implements SubjectDao {

    @Override
    public Subject findSubjectByName(String subjectName) {
        Query query = createQuery("from Subject where name =:subjectname");
        query.setParameter("subjectname", subjectName);
        return (Subject) query.uniqueResult();
    }

    @Override
    public Subject findSubjectByIdSubject(Long id) {
        return getByKey(id);
    }

    @Override
    public List<Subject> findSubjectsByIdClass(Long id) {
        Query query = createQuery("SELECT  s FROM Subject s , TeacherSubjectClass tsc, Class c where tsc.aClass=c.idclass and c.idclass=:id and tsc.subject=s.idsubject order by s.name");
        query.setParameter("id", id);
        List<Subject> listOfSubjects = query.list();
        if(listOfSubjects==null)
            return Collections.emptyList();
        return  listOfSubjects;
    }

    @Override
    public List<Subject> findAll() {
        Query query = createQuery("FROM Subject s order by s.name");
        List<Subject> listOfSubjects = query.list();
        if(listOfSubjects==null)
            return Collections.emptyList();
        return  listOfSubjects;
    }

    @Override
    public void addSubject(Subject subject) {
        persist(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
delete(subject);
    }
}
