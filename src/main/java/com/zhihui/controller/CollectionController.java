package com.zhihui.controller;

import com.zhihui.entity.Goods;
import com.zhihui.service.CollectiongService;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CollectionController {
    @Autowired
    private CollectiongService collectiongService;

    @ApiOperation(notes = "我的收藏接口",value = "商品收藏")
    @RequestMapping("findCollById.do")
    public ResultVo findCollById(Integer uid){
        List<Goods> list = collectiongService.findCollById(uid);
        return ResultVo.setOK(list);
    }
}
