package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.ClassDao;
import com.example.demo.domain.Class;
import com.example.demo.domain.Student;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Transactional
@Repository("classDao")
public class ClassDaoImpl extends AbstractDao<Long, Class> implements ClassDao {

    @Override
    public Class findClassByName(String className) {
        Query query = createQuery("from Class where name =:classname");
        query.setParameter("classname", className);
        return (Class) query.uniqueResult();
    }

    @Override
    public Class findClassByIdClass(Long id) {
        return getByKey(id);
    }

    @Override
    public List<Class> findAll() {
        Query query = createQuery("FROM Class c order by c.name");
        List<Class> listOfClass = query.list();
        if(listOfClass==null)
            return Collections.emptyList();
        return  listOfClass;
    }

    @Override
    public void addClass(Class cl) {
    persist(cl);
    }

    @Override
    public void deleteClass(Class cl) {
        delete(cl);
    }
}
