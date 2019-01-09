package com.zhihui.service;

import com.zhihui.entity.Goods;

import java.util.List;

public interface CollectiongService {
    //根据用户id，查询用户收藏的商品信息
    public List<Goods> findCollById(Integer uid);

}
