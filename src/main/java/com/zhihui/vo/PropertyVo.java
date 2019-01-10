package com.zhihui.vo;

import com.zhihui.entity.GoodsProperty;

import java.util.List;

public class PropertyVo {

    private int pid;

    private String info;

    private List<GoodsProperty> childs;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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
