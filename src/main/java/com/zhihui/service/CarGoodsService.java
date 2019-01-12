package com.zhihui.service;

import com.zhihui.entity.CarGoods;

import java.util.List;

public interface CarGoodsService {

    public  void insertCgoods(CarGoods carGoods,String token);
    public List<CarGoods> findCarGoods(String token);
}
