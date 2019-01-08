package com.zhihui.dao;

import com.zhihui.entity.CarGoods;

public interface CarGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarGoods record);

    int insertSelective(CarGoods record);

    CarGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarGoods record);

    int updateByPrimaryKey(CarGoods record);
}