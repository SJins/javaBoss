package com.zhihui.controller;

import com.zhihui.entity.User;
import com.zhihui.service.UserService;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(produces = "用户类接口文档", value = "接口文档")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //用户注册
    @ApiOperation(notes = "注册账号接口", value = "注册")
    @PostMapping("register.do")
    public ResultVo registerUser(User user) {
        return userService.register(user);
    }
}
