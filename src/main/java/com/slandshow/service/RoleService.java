package com.slandshow.service;

import com.slandshow.models.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    Role getRole();

    void saveRole(Role role);

}
