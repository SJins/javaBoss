package com.zhihui.controller;

import com.zhihui.service.UserDetailService;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(produces = "用户详情类接口文档", value = "接口文档")
@RestController
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;

    @ApiOperation(notes = "根据传来的token令牌查找到个人信息返回", value = "个人信息接口")
    @PostMapping("/user/myself.do")
    public ResultVo myself(String token){
        return userDetailService.myselfMsg(token);
    }
}
