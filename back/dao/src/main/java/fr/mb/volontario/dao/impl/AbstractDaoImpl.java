package fr.mb.volontario.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.Serializable;
import java.util.List;

public abstract class AbstractDaoImpl<T extends Serializable> {
    protected Class<T> entityClass;

    @Autowired
    SessionFactory sessionFactory;

    public AbstractDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    public void persist(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);


    }


    public void update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);


    }


    public T findById(int id) {
        Session session = sessionFactory.getCurrentSession();

        T entity=(session.get(entityClass,id));

        return entity;
    }


    public void delete(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);

    }


    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();

        Query query=session.createQuery("from "+entityClass.getName());
        List<T> list = query.list();

        return list;
    }


    public List<T> findAllOffset(Integer offset, Integer nbPages) {
        Session session = sessionFactory.getCurrentSession();


        Query query=session.createQuery("from "+entityClass.getName());
        query.setFirstResult(offset);
        query.setMaxResults(nbPages);

        List<T> list = query.list();

        return list;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setEntityClass( Class<T> classToSet ) {
        this.entityClass = classToSet;
    }
    public Class <T> getEntityClass() {
        return entityClass;
    }
}
