package com.zhihui.controller;

import com.zhihui.entity.GoodsType;
import com.zhihui.service.GoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(produces = "商品类接口文档", value = "接口文档")
@Controller
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @ApiOperation(notes = "展示所有商品类型", tags = "展示商品类型" ,value = "展示商品类型")
    @RequestMapping("goodsType/findAll.do")
    @ResponseBody
    /**
     *展示所有商品类型
     */
    public List<GoodsType> findAll() {

        return goodsTypeService.findAll();
    }
}
