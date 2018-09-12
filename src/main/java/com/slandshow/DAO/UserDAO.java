package com.slandshow.DAO;

import com.slandshow.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO<E extends User> extends GenericDAO<E> {

    void save(User user);

    void updateProfile(User user);

    User findUserByLogin(String login);

    User findUserByName(String firstName, String lastName);

    int addUserRole(Long userId, Long roleId);

    void deleteUserRole(Long userId);

}