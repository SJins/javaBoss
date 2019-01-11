package com.zhihui.controller;

import com.zhihui.Utils.CodeUtil;
import com.zhihui.Utils.EmailUtil;
import com.zhihui.Utils.JedisUtil;
import com.zhihui.entity.User;
import com.zhihui.service.UserService;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(produces = "用户类接口文档", value = "接口文档")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //用户注册
    @ApiOperation(notes = "注册账号接口", value = "注册")
    @PostMapping("register.do")
    public ResultVo registerUser(User user, String code) {

        JedisUtil jedisUtil = new JedisUtil("39.105.189.141",6379,"qfjava");
        if(jedisUtil.exists(user.getEmail())){
            if(jedisUtil.get(user.getEmail()).equals(code)){
                return userService.register(user);
            }
        }
        return ResultVo.setERROR();
    }

    // 用户登录
    @ApiOperation(notes = "登录接口,登录成功返回token", value = "登录")
    @PostMapping("login.do")
    public ResultVo login(User user) {
        return userService.login(user);
    }

    // 用户注销
    @ApiOperation(notes = "注销接口,注销成功销毁token", value = "注销")
    @PostMapping("logout.do")
    public ResultVo logout(String token) {
        return userService.logout(token);
    }

    @ApiOperation(notes = "验证码接口，需要传过来邮箱地址，验证码有效期三分钟",value = "注册邮箱验证码")
    @GetMapping("sendcodetoeamil.do")
    public ResultVo sendCodeToEmail(String email){
        String random = CodeUtil.random();
        JedisUtil jedisUtil = new JedisUtil("39.105.189.141",6379,"qfjava");
        jedisUtil.save(email,random);
        jedisUtil.expire(email,180);
       return EmailUtil.sendCodeToEmail(email, random);
    }
}
