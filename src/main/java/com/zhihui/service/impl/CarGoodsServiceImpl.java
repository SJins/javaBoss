package com.zhihui.service.impl;

import com.zhihui.dao.CarGoodsMapper;
import com.zhihui.dao.ShoppingCartMapper;
import com.zhihui.dao.UserMapper;
import com.zhihui.entity.CarGoods;
import com.zhihui.entity.ShoppingCart;
import com.zhihui.entity.User;
import com.zhihui.service.CarGoodsService;
import com.zhihui.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarGoodsServiceImpl implements CarGoodsService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private CarGoodsMapper carGoodsMapper;

    @Override
    public void insertCgoods(CarGoods carGoods,String token) {
        User user = Token.token.get(token);
        //获取用户的id
        Integer id = user.getId();
        //根据用户id,查找ShopCart对象
        ShoppingCart shop = shoppingCartMapper.findShop(id);
        //创建对象
        ShoppingCart shoppingCart = new ShoppingCart();
        //将用户id,添加到shopcart对象中
        shoppingCart.setUid(id);
        //判断uid是否存在
        if (shop == null) {
            //添加shopcart对象
            shoppingCartMapper.insertScart(shoppingCart);
            //获取shopcat的id,xml加获取id数据
            carGoods.setScid(shoppingCart.getId());
            carGoodsMapper.insertCgoods(carGoods);
        } else {
            carGoods.setScid(shop.getId());
            carGoodsMapper.insertCgoods(carGoods);
        }

    }

    @Override
    public List<CarGoods> findCarGoods(String token) {
        User user = Token.token.get(token);
        Integer id = user.getId();
        List<CarGoods> carGoods = carGoodsMapper.findCarGoods(id);
        return carGoods;
    }
}