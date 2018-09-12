package com.slandshow.DAO.Impl;

import com.slandshow.DAO.UserDAO;
import com.slandshow.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl<E extends User> extends GenericDAOImpl<E> implements UserDAO<E> {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void updateProfile(User user) {
        sessionFactory.getCurrentSession().createQuery("UPDATE User SET " +
                "firstName = :firstName, lastName = :lastName, login = :login where id =: id")
                .setParameter("firstName", user.getFirstName())
                .setParameter("lastName", user.getLastName())
                .setParameter("login", user.getLogin())
                .setParameter("id", user.getId())
                .executeUpdate();
    }

    public User findUserByLogin(String login) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User u where login = :login")
                .setParameter("login", login)
                .uniqueResult();
    }

    public User findUserByName(String firstName, String lastName) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User u where firstName = :firstName and lastName = :lastName")
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .uniqueResult();
    }

    // Native SQL
    public int addUserRole(Long userId, Long roleId) {
        return sessionFactory.getCurrentSession().createNativeQuery(
                "INSERT INTO user_role (user_id, role_id) " +
                        "VALUES (?, ?)"
        )
                .setParameter(1, userId)
                .setParameter(2, roleId)
                .executeUpdate();
    }

    public void deleteUserRole(Long userId) {
        sessionFactory.getCurrentSession()
                .createNativeQuery(
                        "DELETE FROM user_role " +
                                "WHERE user_id = ? "
                )
                .setParameter(1, userId)
                .executeUpdate();
    }

}
