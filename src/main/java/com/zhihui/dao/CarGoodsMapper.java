package com.zhihui.dao;

import com.zhihui.entity.CarGoods;

import java.util.List;

public interface CarGoodsMapper {
    int deleteByPrimaryKey(Integer id);
    //添加购物车
    public void insertCgoods(CarGoods record);

    int insertSelective(CarGoods record);

    CarGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarGoods record);

    int updateByPrimaryKey(CarGoods record);

    //根据用户id,展示购物车信息
    public List<CarGoods> findCarGoods(Integer id);


}