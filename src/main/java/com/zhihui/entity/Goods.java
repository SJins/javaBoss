package com.zhihui.entity;

import java.util.Date;
import java.util.List;

public class Goods {
    private Integer id;

    private String goodsname;

    private Date shelftime;

    private Integer commentnum;

    private Integer collectionnum;

    private String brief;

    private Integer discount;

    private String discountdetail;

    private Integer gtid;

    private Integer flag;

    private Float price;
    //一个商品对应多个图片
    private List<Goodsimgs> goodsimgs;
    /**
     * 一个商品对应多个属性；
     */
    private List<GoodsProperty> properties;

    public List<Goodsimgs> getGoodsimgs() {
        return goodsimgs;
    }

    public void setGoodsimgs(List<Goodsimgs> goodsimgs) {
        this.goodsimgs = goodsimgs;
    }

    public List<GoodsProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<GoodsProperty> properties) {
        this.properties = properties;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Date getShelftime() {
        return shelftime;
    }

    public void setShelftime(Date shelftime) {
        this.shelftime = shelftime;
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    public Integer getCollectionnum() {
        return collectionnum;
    }

    public void setCollectionnum(Integer collectionnum) {
        this.collectionnum = collectionnum;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDiscountdetail() {
        return discountdetail;
    }

    public void setDiscountdetail(String discountdetail) {
        this.discountdetail = discountdetail == null ? null : discountdetail.trim();
    }

    public Integer getGtid() {
        return gtid;
    }

    public void setGtid(Integer gtid) {
        this.gtid = gtid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}