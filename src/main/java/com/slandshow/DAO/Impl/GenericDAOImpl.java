package com.slandshow.DAO.Impl;

import com.slandshow.DAO.GenericDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class GenericDAOImpl<E> implements GenericDAO<E> {

    private Class<E> entityClass;

    public GenericDAOImpl() {
        this.entityClass = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericDAO.class);
    }

    // TODO: Add @Autowired and set-up sessionFactory via Spring MVC
    //@Autowired
    private SessionFactory sessionFactory;

    public void add(E entity) {
        sessionFactory.getCurrentSession()
                .save(entity);
    }

    public void update(E entity) {
        sessionFactory.getCurrentSession()
                .update(entity);
    }

    public void delete(E entity) {
        sessionFactory.getCurrentSession()
                .delete(entity);
    }

    public List<E> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from " + entityClass.getName())
                .getResultList();
    }

    public E getById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(entityClass, id);
    }

}
