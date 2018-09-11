package com.slandshow.DAO.Impl;

import com.slandshow.DAO.RoleDAO;
import com.slandshow.models.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public Role getRole() {
        return (Role) sessionFactory.getCurrentSession()
                .createQuery("FROM Role where type = :ROLE")
                .setParameter("ROLE", "ROLE_USER")
                .uniqueResult();
    }

    public void addRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }
}
