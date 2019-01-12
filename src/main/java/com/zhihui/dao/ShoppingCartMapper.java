package com.zhihui.dao;

import com.zhihui.entity.ShoppingCart;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Integer id);
    //添加购物车
    public void insertScart(ShoppingCart record);
    public ShoppingCart findShop(Integer uid);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}