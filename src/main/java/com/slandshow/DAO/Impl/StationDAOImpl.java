package com.slandshow.DAO.Impl;

import com.slandshow.DAO.StationDAO;
import com.slandshow.models.Station;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StationDAOImpl<E extends Station> extends GenericDAOImpl<E> implements StationDAO<E> {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Station getByName(String name) {
        return (Station) sessionFactory.getCurrentSession()
                .createQuery("from Station where name = :name")
                .setParameter("name", name)
                .uniqueResult();
    }

}
