package com.lgh.chinasoft.ticket.server.service.impl;

import com.lgh.chinasoft.ticket.server.common.ServerException;
import com.lgh.chinasoft.ticket.server.dao.UserRepo;
import com.lgh.chinasoft.ticket.server.model.User;
import com.lgh.chinasoft.ticket.server.service.UserService;
import com.lgh.chinasoft.ticket.server.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepo userRepo;

    @Override
    public User register(User user) {
        String userId = UUIDUtil.uuid();
        user.setId(userId);
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getNumber()) || StringUtils.isEmpty(user.getPassword())) {
            throw new ServerException("user name number password can't be empty");
        }
        User existUser = userRepo.queryByNumber(user.getNumber());
        if(existUser != null){
            throw new ServerException("user exist");
        }
        int i = userRepo.addUser(user);
        if(i > 0){
            return user;
        }else {
            throw new ServerException("register user failed");
        }
    }
}
