package com.lgh.chinasoft.ticket.server.dao;

import com.lgh.chinasoft.ticket.server.model.Role;
import com.lgh.chinasoft.ticket.server.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface UserRepo {

    /**
     * 查询用户
     *
     * @param number number
     * @return user
     */
    User queryByNumber(@Param("number") String number);

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 是否成功 大于0为成功
     */
    int addUser(@Param("user") User user);

    /**
     * 给用户添加角色
     *
     * @param userId 用户ID
     * @param roleId 角色ID
     * @return status
     */
    int addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 查询用户角色
     * @param userId 用户Id
     * @return 角色
     */
    Role queryUserRole(@Param("userId") String userId);
}
