package com.zhihui.entity;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class UserDetail {
    private Integer id;

    private String img;

    private Integer sex;

    private Date birthday;

    private Integer level;

    private Integer uid;

    private String idcarimg;

    private Integer goldcoin;

    private Integer integral;

    private Integer vitalityvalue;

    private Integer growthrate;

    private Integer growvalue;

    private MultipartFile file;
    //添加映射字段
    private  User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getIdcarimg() {
        return idcarimg;
    }

    public void setIdcarimg(String idcarimg) {
        this.idcarimg = idcarimg == null ? null : idcarimg.trim();
    }

    public Integer getGoldcoin() {
        return goldcoin;
    }

    public void setGoldcoin(Integer goldcoin) {
        this.goldcoin = goldcoin;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getVitalityvalue() {
        return vitalityvalue;
    }

    public void setVitalityvalue(Integer vitalityvalue) {
        this.vitalityvalue = vitalityvalue;
    }

    public Integer getGrowthrate() {
        return growthrate;
    }

    public void setGrowthrate(Integer growthrate) {
        this.growthrate = growthrate;
    }

    public Integer getGrowvalue() {
        return growvalue;
    }

    public void setGrowvalue(Integer growvalue) {
        this.growvalue = growvalue;
    }
}