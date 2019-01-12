package com.zhihui.service;

import com.zhihui.entity.ShoppingCart;

public interface ShoppingCartServiec {

    public  void insertScart(ShoppingCart shoppingCart);
    public ShoppingCart findShop(Integer uid);
}
