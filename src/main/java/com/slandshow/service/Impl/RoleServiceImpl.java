package com.slandshow.service.Impl;

import com.slandshow.DAO.RoleDAO;
import com.slandshow.models.Role;
import com.slandshow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Transactional
    public Role getRole() {
        return roleDAO.getRole();
    }

}
