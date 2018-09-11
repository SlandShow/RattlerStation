package com.slandshow.service;

import com.slandshow.DTO.UserDTO;
import com.slandshow.models.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Service
public interface UserService {

    void add(User user);

    void remove(User user);

    List<User> getUsers();

    UserDTO findAuthenticatedUserDTO();

    User findAuthenticatedUser();

    User findUserByEmail(String email);

    void update(User user);

    void updateProfile(UserDTO userDTO) throws ParseException;

    void registration(UserDTO userDTO) throws IOException;

    void addUserRole(Long userId, Long roleId);

}
