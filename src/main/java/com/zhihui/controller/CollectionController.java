package com.zhihui.controller;

import com.zhihui.entity.Goods;
import com.zhihui.entity.Strategy;
import com.zhihui.service.CollectiongService;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CollectionController {
    @Autowired
    private CollectiongService collectiongService;

    @ApiOperation(notes = "我的收藏接口",value = "商品收藏")
    @GetMapping("findCollById.do")
    public ResultVo findCollById(Integer uid){
        List<Goods> list = collectiongService.findCollById(uid);
        return ResultVo.setOK(list);
    }

    @ApiOperation(notes = "我的收藏接口",value = "攻略收藏/我的攻略")
    @GetMapping("findCollStraById.do")
    public  ResultVo findCollStraById(Integer id){
        List<Strategy> list = collectiongService.findCollStraById(id);
        return ResultVo.setOK(list);
    }

    @ApiOperation(notes = "通过token和传来攻略的id，添加到个人攻略收藏列表中", value = "收藏攻略功能")
    @PostMapping("/user/collectionTheStrategy.do")
    public ResultVo collectionTheStrategy(String token, Integer id){
        return collectiongService.addStrategyToCollection(token,id);
    }

    @ApiOperation(notes = "通过token和传来商品的id，添加到个人商品收藏列表中", value = "收藏商品功能")
    @PostMapping("/user/collectionTheGoods.do")
    public ResultVo collectionTheGoods(String token, Integer id){
        return collectiongService.addGoodsToCollection(token,id);
    }
}
