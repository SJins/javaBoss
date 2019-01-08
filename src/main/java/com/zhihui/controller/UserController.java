package com.zhihui.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Api(produces = "用户类接口文档", value = "接口文档")
@RestController
public class UserController {


    //随机生成指定位数的数字
    @ApiOperation(notes = "实现传递参数，响应指定位数的随机数", tags = "随机生成数据" ,value = "随机数")
    @GetMapping("/random.do")
    public String createNum(int len){
        Random random=new Random();
        //3  100-999 10(3-1) 10(3)-1
        return (random.nextInt((int) Math.pow(10,len)-(int)Math.pow(10,len-1))+(int)Math.pow(10,len-1))+"";

    }
}
