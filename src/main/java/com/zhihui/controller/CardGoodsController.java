package com.zhihui.controller;

import com.zhihui.entity.CarGoods;
import com.zhihui.entity.ShoppingCart;
import com.zhihui.service.CarGoodsService;
import com.zhihui.service.ShoppingCartServiec;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardGoodsController {
   @Autowired
   private  CarGoodsService carGoodsService;
   @Autowired
   private  ShoppingCartServiec shoppingCartServiec;
   @GetMapping("addCart.do")
   @ApiOperation(notes = "购物车添加",value = "购物车添加商品接口")
    public ResultVo addCart(CarGoods carGoods,String token){

        carGoodsService.insertCgoods(carGoods,token);

        return  ResultVo.setOK(0);
    }

    @GetMapping("findCarGoods.do")
    @ApiOperation(notes = "购物车显示商品",value = "购物车显示商品")
    public ResultVo findCarGoods(String token){
        List<CarGoods> list = carGoodsService.findCarGoods(token);
        return  ResultVo.setOK(list);
    }

}
