package com.zhihui.vo;

import java.util.List;

public class CommentVo {

    private Integer id;

    private String img;

    private String name;

    private String commentTime;

    private String content;

    private Integer Commentnum;

    private List<ReplyVo> replys;

    public Integer getCommentnum() {
        return Commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        Commentnum = commentnum;
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
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ReplyVo> getReplys() {
        return replys;
    }

    public void setReplys(List<ReplyVo> replys) {
        this.replys = replys;
    }
}
