package com.lgh.chinasoft.ticket.server.controller.guest;

import com.lgh.chinasoft.ticket.server.common.Response;
import com.lgh.chinasoft.ticket.server.model.User;
import com.lgh.chinasoft.ticket.server.service.UserService;
import com.lgh.chinasoft.ticket.server.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
@Api(tags = "user management")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "user register")
    public Response register(@RequestBody User user){
        User resultUser = userService.register(user);
        return ResponseUtil.success(resultUser);
    }

    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "user login")
    public Response login(@RequestBody User user){
        User loginUser = userService.login(user.getNumber(),user.getPassword());
        return ResponseUtil.success(loginUser);
    }

}
