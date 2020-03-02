package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.TeacherDao;
import com.example.demo.dao.TeacherSubjectClassDao;
import com.example.demo.domain.Class;
import com.example.demo.domain.Subject;
import com.example.demo.domain.Teacher;
import com.example.demo.domain.TeacherSubjectClass;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Transactional
@Repository("teacherSubjectClassDao")
public class TeacherSubjectClassDaoImpl extends AbstractDao<Long, TeacherSubjectClass> implements TeacherSubjectClassDao {
    @Override
    public List<Class> findClassesByIdTeacher(Long id) {
       // Query query = createQuery("SELECT c  FROM Class c , TeacherSubjectClass t where t.teacher =: id");
        Query query = createQuery("SELECT  c FROM Class c , TeacherSubjectClass t ,Teacher e where t.teacher = e.idTeacher and c.idclass = t.aClass and e.idTeacher=:id order by t.id");
        query.setParameter("id", id);
        List<Class> listOfClass = query.list();
                if(listOfClass==null)
            return Collections.emptyList();
                return  listOfClass;
    }

    @Override
    public List<Subject> findSubjectsByIdTeacher(Long idTeacher) {
        Query query = createQuery("SELECT  s FROM Subject s , TeacherSubjectClass t ,Teacher e where t.teacher = e.idTeacher and s.idsubject = t.subject and e.idTeacher=:id order by t.id");
        query.setParameter("id", idTeacher);
        List<Subject> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public List<Teacher> findTeacherByIdClass(Long id) {
        Query query = createQuery("FROM Teacher t , TeacherSubjectClass c, Class k where c.aClass = k.idclass and t.idTeacher = c.teacher and k.idclass=:id");
        query.setParameter("id", id);
        List<Teacher> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public List<TeacherSubjectClass> findTSCByIdTeacher(Long id) {
        Query query = createQuery("SELECT  t FROM  TeacherSubjectClass t ,Teacher e where t.teacher = e.idTeacher  and e.idTeacher=:id order by t.id");
        query.setParameter("id", id);
        List<TeacherSubjectClass> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public List<TeacherSubjectClass> findTSCByIdClass(Long id) {
        Query query = createQuery("select c FROM  TeacherSubjectClass c, Class k where c.aClass = k.idclass and k.idclass=:id");
        query.setParameter("id", id);
        List<TeacherSubjectClass> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public List<TeacherSubjectClass> findTSCByIdSubject(Long id) {
        Query query = createQuery("select c FROM  TeacherSubjectClass c, Subject s where c.subject = s.idsubject and s.idsubject=:id");
        query.setParameter("id", id);
        List<TeacherSubjectClass> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public TeacherSubjectClass findTSCByIdTSC(Long idTSC) {
        return getByKey(idTSC);
    }

    @Override
    public TeacherSubjectClass findTSCByIdClassAndIdSubject(Long idClass, Long idSubject) {
        Query query = createQuery("select tsc from TeacherSubjectClass tsc, Class c, Subject s  where tsc.aClass =c.idclass and tsc.subject=s.idsubject and c.idclass=:idClass and s.idsubject=:idSubject");
        query.setParameter("idClass", idClass);
        query.setParameter("idSubject",idSubject);
        return (TeacherSubjectClass) query.uniqueResult();
    }

    @Override
    public void addTSC(TeacherSubjectClass tsc) {
persist(tsc);
    }

    @Override
    public void deleteTSC(TeacherSubjectClass tsc) {
delete(tsc);
    }
//    @Override
//    public List<Employer> getAllEmployers() {
//        Query query = createQuery("from Employer");
//        List<Employer> listOfEmployers = query.list();
//        if(listOfEmployers==null)
//            return Collections.emptyList();
//        return listOfEmployers;
//    }
}