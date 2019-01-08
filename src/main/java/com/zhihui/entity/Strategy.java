package com.zhihui.entity;

import java.util.Date;

public class Strategy {
    private Integer id;

    private Integer uid;

    private Integer collectioncount;

    private Integer commentcount;

    private String strategytitle;

    private Integer readingcount;

    private Date deploytime;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCollectioncount() {
        return collectioncount;
    }

    public void setCollectioncount(Integer collectioncount) {
        this.collectioncount = collectioncount;
    }

    public Integer getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }

    public String getStrategytitle() {
        return strategytitle;
    }

    public void setStrategytitle(String strategytitle) {
        this.strategytitle = strategytitle == null ? null : strategytitle.trim();
    }

    public Integer getReadingcount() {
        return readingcount;
    }

    public void setReadingcount(Integer readingcount) {
        this.readingcount = readingcount;
    }

    public Date getDeploytime() {
        return deploytime;
    }

    public void setDeploytime(Date deploytime) {
        this.deploytime = deploytime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}