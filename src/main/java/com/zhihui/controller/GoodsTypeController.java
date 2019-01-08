package com.zhihui.controller;

import com.zhihui.entity.GoodsType;
import com.zhihui.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @RequestMapping("goodsType/findAll.do")
    @ResponseBody
    public List<GoodsType> findAll() {

        return goodsTypeService.findAll();
    }
}
