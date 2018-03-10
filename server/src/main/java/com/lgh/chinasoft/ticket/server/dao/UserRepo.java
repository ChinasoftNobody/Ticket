package com.lgh.chinasoft.ticket.server.dao;

import com.lgh.chinasoft.ticket.server.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface UserRepo {

    /**
     * 查询用户
     * @param number number
     * @return user
     */
    User queryByNumber(String number);

    /**
     * 添加用户
     * @param user 用户
     * @return 是否成功 大于0为成功
     */
    int addUser(User user);
}
