package com.lgh.chinasoft.ticket.server.service;

import com.lgh.chinasoft.ticket.server.model.User;

/**
 * @author Administrator
 */
public interface UserService {
    /**
     * 注册用户
     * @param user 用户
     * @return 已注册的用户
     */
    User register(User user);
}
