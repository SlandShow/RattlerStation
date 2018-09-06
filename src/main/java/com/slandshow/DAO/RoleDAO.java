package com.slandshow.DAO;

import com.slandshow.models.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO {

    Role getRole();

}
