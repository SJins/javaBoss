package com.zhihui.controller;

import com.zhihui.entity.Goods;
import com.zhihui.service.CollectiongService;
import com.zhihui.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectionController {
    @Autowired
    private CollectiongService collectiongService;

    @RequestMapping("findCollById.do")
    public ResultVo findCollById(Integer uid){
        List<Goods> list = collectiongService.findCollById(uid);
        return ResultVo.setOK(list);
    }
}
