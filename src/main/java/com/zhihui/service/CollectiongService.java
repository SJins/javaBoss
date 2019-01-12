package com.zhihui.service;

import com.zhihui.entity.Goods;
import com.zhihui.entity.Strategy;
import com.zhihui.vo.ResultVo;

import java.util.List;

public interface CollectiongService {
    //根据用户id，查询用户收藏的商品信息
    public List<Goods> findCollById(Integer uid);

    //根据用户id,查找用户收藏的攻略信息
    public  List<Strategy> findCollStraById(Integer id);

    ResultVo addStrategyToCollection(String token, Integer id);

    ResultVo addGoodsToCollection(String token, Integer id);
}
