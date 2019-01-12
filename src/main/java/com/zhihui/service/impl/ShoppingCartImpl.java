package com.zhihui.service.impl;

import com.zhihui.dao.ShoppingCartMapper;
import com.zhihui.entity.ShoppingCart;
import com.zhihui.service.ShoppingCartServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartImpl implements ShoppingCartServiec {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Override
    public void insertScart(ShoppingCart shoppingCart) {
        shoppingCartMapper.insertScart(shoppingCart);
    }

    @Override
    public ShoppingCart findShop(Integer uid) {
        ShoppingCart shop = shoppingCartMapper.findShop(uid);
        return shop;
    }


}
