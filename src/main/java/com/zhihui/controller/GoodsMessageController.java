package com.zhihui.controller;

import com.zhihui.service.GoodsMessageService;
import com.zhihui.vo.GoodsMessageVo;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(produces = "商品类接口文档", value = "接口文档")
@Controller
public class GoodsMessageController {

    @Autowired
    private GoodsMessageService goodsMessageService;

    @ApiOperation(notes = "展示所有商品信息", tags = "展示商品信息" ,value = "商品信息展示")
    @RequestMapping("findGoodsMessage.do")
    @ResponseBody
    public ResultVo findGoodsMessage(Integer id) {

        return goodsMessageService.findGoodsMessageById(id);
    }
}
