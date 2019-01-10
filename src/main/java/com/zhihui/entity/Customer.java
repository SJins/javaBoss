package com.zhihui.entity;

public class Customer {
    private Integer cid;

    private String cname;

    private String via;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via == null ? null : via.trim();
    }
}