package com.zhihui.controller;

import com.zhihui.service.ReceivingService;
import com.zhihui.vo.ResultVo;
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

    @RequestMapping("findOneRec.do")
    public ResultVo findOneRec(Integer uid){
        return  receivingService.findOneRec(uid);
    }
}
