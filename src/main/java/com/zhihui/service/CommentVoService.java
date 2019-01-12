package com.zhihui.service;

import com.zhihui.entity.Comment;
import com.zhihui.vo.CommentVo;
import com.zhihui.vo.ResultVo;

import java.util.List;

public interface CommentVoService {

    /**
     * 根据商品id查询对应评论
     * @param gid
     * @return
     */
    List<CommentVo> findCommentByGid(Integer gid);

    /**
     * 根据评论id查询对应评论
     * @param sid
     * @return
     */
    List<CommentVo> findCommentBySid(Integer sid);

    /**
     * 添加商品评论
     * @param comment
     * @param token
     * @return
     */
    ResultVo addCommentByGid(Comment comment, String token);


}
