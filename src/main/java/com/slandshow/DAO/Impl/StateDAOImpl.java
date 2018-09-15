package com.slandshow.DAO.Impl;

import com.slandshow.DAO.StateDAO;
import com.slandshow.models.State;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StateDAOImpl <E extends State> extends GenericDAOImpl<E> implements StateDAO<E> {

    @Autowired
    private SessionFactory sessionFactory;

    public State getByType(String type) {
        return (State) sessionFactory.getCurrentSession()
                .createQuery("from State where type = :type")
                .setParameter("type", type)
                .uniqueResult();
    }
}
