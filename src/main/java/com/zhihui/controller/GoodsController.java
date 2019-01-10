package com.zhihui.controller;

import com.tools.vo.PageBeanVo;
import com.zhihui.service.GoodsService;
import com.zhihui.service.GoodsViewVoService;
import com.zhihui.vo.GoodsViewVo;
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
public class GoodsController {

    @Autowired
    private GoodsViewVoService goodsViewVoService;

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(notes = "展示所有商品类型", tags = "展示商品类型" ,value = "展示商品类型")
    @RequestMapping("findGoodsView.do")
    @ResponseBody
    /**
     * 展示商品列表
     */
    public PageBeanVo<GoodsViewVo> findAllByGtid(Integer gtid, int page, int limit) {

        return goodsViewVoService.findgoodsView(gtid,page,limit);
    }

    @ApiOperation(notes = "展示对应商品属性名字", value = "展示商品属性")
    @RequestMapping("findGoodsProperty.do")
    @ResponseBody
    public ResultVo findGoodsProperty(Integer id) {
        return goodsService.findGoodsProperty(id);
    }


}
