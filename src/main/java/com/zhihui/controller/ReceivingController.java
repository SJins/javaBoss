package com.zhihui.controller;

import com.zhihui.service.ReceivingService;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("/receiving")

public class ReceivingController {
    @Autowired
    private ReceivingService receivingService;

    @ApiOperation(notes = "我的收货地址接口", value = "我的地址")
    @RequestMapping("findOneRec.do")
    public ResultVo findOneRec(Integer uid){
        return  receivingService.findOneRec(uid);
    }
}
