package com.zhihui.dao;

import com.zhihui.entity.CarGoods;

public interface CarGoodsMapper {
    int deleteByPrimaryKey(Integer id);
    //添加购物车
    public void insertCgoods(CarGoods record);

    int insertSelective(CarGoods record);

    CarGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarGoods record);

    int updateByPrimaryKey(CarGoods record);



}