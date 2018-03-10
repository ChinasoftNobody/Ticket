package com.lgh.chinasoft.ticket.server.dao;

import com.lgh.chinasoft.ticket.server.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface RoleRepo {
    /**
     * 根据名称查询用户
     * @param name name
     * @return role
     */
    Role queryByName(@Param("name") String name);
}
