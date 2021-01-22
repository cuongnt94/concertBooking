package com.example.concertbooking.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class AbstractHibernateDAO<T extends Serializable> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }


    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
