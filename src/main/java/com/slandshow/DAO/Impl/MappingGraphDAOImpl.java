package com.slandshow.DAO.Impl;

import com.slandshow.DAO.GenericDAO;
import com.slandshow.DAO.MappingGraphDAO;
import com.slandshow.models.MappingEdge;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MappingGraphDAOImpl<E extends MappingEdge> extends GenericDAOImpl<E> implements MappingGraphDAO<E> {

    @Autowired
    private SessionFactory sessionFactory;

    public List<MappingEdge> getAllEdges() {
        return sessionFactory.getCurrentSession().createQuery(
                "from MappingEdge "
        ).getResultList();
    }
}
