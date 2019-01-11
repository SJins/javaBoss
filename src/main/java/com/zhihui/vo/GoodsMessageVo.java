package com.zhihui.vo;

import com.zhihui.entity.Goods;
import com.zhihui.entity.Goodsimgs;

import java.math.BigDecimal;
import java.util.List;

public class GoodsMessageVo {

    private List<Goodsimgs> goodsimgs;

    private Goods goods;

    private BigDecimal dPrice;

    public List<Goodsimgs> getGoodsimgs() {
        return goodsimgs;
    }

    public void setGoodsimgs(List<Goodsimgs> goodsimgs) {
        this.goodsimgs = goodsimgs;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getdPrice() {
        return dPrice;
    }

    public void setdPrice(BigDecimal dPrice) {
        this.dPrice = dPrice;
    }
}
