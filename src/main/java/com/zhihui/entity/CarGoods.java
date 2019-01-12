package com.zhihui.entity;

import java.util.List;

public class CarGoods {
    private Integer id;

    private Integer scid;

    private Integer gid;

    private Integer num;

    //加入映射字段
    private List<Goods> goods;
    private  List<GoodsProperty> goodsProperties;
    private ShoppingCart shoppingCart;
    private User user;


    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<GoodsProperty> getGoodsProperties() {
        return goodsProperties;
    }

    public void setGoodsProperties(List<GoodsProperty> goodsProperties) {
        this.goodsProperties = goodsProperties;
    }


    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}