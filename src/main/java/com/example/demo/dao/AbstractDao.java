package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@Transactional
public abstract class AbstractDao<PK extends Serializable, T> {
    private final Class<T> persistentClass;

   @Autowired
    private  SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }


    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected T getByKey(PK key) {
        return getSession().get(persistentClass, key);
    }

    protected void persist(T entity) {
        getSession().persist(entity);
    }

    protected void merge(T entity) {
        getSession().merge(entity);
    }

    protected void update(T entity) {
        getSession().update(entity);
    }

    protected void delete(T entity) {
        getSession().delete(entity);
    }

    protected Query createQuery(String hql){
        return getSession().createQuery(hql);
    }
}