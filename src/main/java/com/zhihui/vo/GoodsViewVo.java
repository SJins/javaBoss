package com.zhihui.vo;

import com.zhihui.entity.Goods;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class GoodsViewVo {
    private String imgurl;

    private Integer id;

    private String name;

    private String discountdetail;

    private Integer collectionnum;

    private Integer commentnum;

    private String shelftime;

    private Float price;

    private BigDecimal dPrice;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public BigDecimal getdPrice() {
        return dPrice;
    }

    public void setdPrice(BigDecimal dPrice) {
        this.dPrice = dPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscountdetail() {
        return discountdetail;
    }

    public void setDiscountdetail(String discountdetail) {
        this.discountdetail = discountdetail;
    }

    public Integer getCollectionnum() {
        return collectionnum;
    }

    public void setCollectionnum(Integer collectionnum) {
        this.collectionnum = collectionnum;
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    public String getShelftime() {
        return shelftime;
    }

    public void setShelftime(String shelftime) {
        this.shelftime = shelftime;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
