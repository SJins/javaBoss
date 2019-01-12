package com.zhihui.dao;

import com.zhihui.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    /**
     * 根据对应商品id查找对应评论
     * @param gid
     *         商品id
     *
     * @return
     */
    List<Comment> findCommentByGid(Integer gid);

    /**
     * 根据对应攻略id查找对应评论
     * @param sid
     *         攻略id
     *
     * @return
     */
    List<Comment> findCommentBySid(Integer sid);
}