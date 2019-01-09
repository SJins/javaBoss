package com.zhihui.controller;

import com.zhihui.service.GoodsViewVoService;
import com.zhihui.vo.GoodsViewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Api(produces = "商品类接口文档", value = "接口文档")
@Controller
public class GoodsController {

    @Autowired
    private GoodsViewVoService goodsViewVoService;

    @ApiOperation(notes = "展示所有商品类型", tags = "展示商品类型" ,value = "展示商品类型")
    @RequestMapping("findGoodsView.do")
    @ResponseBody
    /**
     * 展示商品列表
     */
    public List<GoodsViewVo> findAllByGtid(Integer gtid) {

        return goodsViewVoService.findgoodsView(gtid);
    }


}
