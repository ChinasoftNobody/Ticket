package com.lgh.chinasoft.ticket.server.service.impl;

import com.lgh.chinasoft.ticket.server.common.Const;
import com.lgh.chinasoft.ticket.server.common.ServerException;
import com.lgh.chinasoft.ticket.server.dao.RoleRepo;
import com.lgh.chinasoft.ticket.server.dao.UserRepo;
import com.lgh.chinasoft.ticket.server.model.Role;
import com.lgh.chinasoft.ticket.server.model.User;
import com.lgh.chinasoft.ticket.server.service.UserService;
import com.lgh.chinasoft.ticket.server.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
/**
 * @author Administrator
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepo userRepo;
    @Resource
    private RoleRepo roleRepo;

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
            Role role = roleRepo.queryByName(Const.ROLE_GUEST);
            if(role == null){
                throw new ServerException("guest role not found");
            }
            if(userRepo.addRoleToUser(user.getId(),role.getId()) <= 0){
                throw new ServerException("add role failed");
            }
            return user;
        }else {
            throw new ServerException("register user failed");
        }
    }

    @Override
    public User login(String number, String password) {
        if(StringUtils.isEmpty(number) || StringUtils.isEmpty(password)){
            throw new ServerException("name and password can't be empty");
        }
        User user = userRepo.queryByNumber(number);
        if(user == null){
            throw new ServerException("user name error");
        }
        if(!user.getPassword().equals(password)){
            throw new ServerException("password error");
        }
        Role role = userRepo.queryUserRole(user.getId());
        if(role == null || !Const.ROLE_GUEST.equals(role.getName())){
            throw new ServerException("user role error");
        }
        return user;
    }
}
