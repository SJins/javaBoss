package com.qfedu.dao;

import com.qfedu.entity.CarGoods;

public interface CarGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarGoods record);

    int insertSelective(CarGoods record);

    CarGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarGoods record);

    int updateByPrimaryKey(CarGoods record);
}