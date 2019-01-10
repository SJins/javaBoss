package com.zhihui.vo;

import com.zhihui.entity.GoodsProperty;

import java.util.List;

public class PropertyVo {

    private int id;

    private String info;

    private List<GoodsProperty> childs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<GoodsProperty> getChilds() {
        return childs;
    }

    public void setChilds(List<GoodsProperty> childs) {
        this.childs = childs;
    }
}
