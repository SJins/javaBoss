package com.zhihui.controller;

import com.zhihui.entity.Comment;
import com.zhihui.service.CommentVoService;
import com.zhihui.vo.CommentVo;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(produces = "评论类接口文档", value = "接口文档")
@Controller
public class GoodsCommentController {

    @Autowired
    private CommentVoService commentVoService;

    @ApiOperation(notes = "展示商品相应评论", value = "展示商品的评论")
    @RequestMapping("findGoodsComment.do")
    @ResponseBody
    public ResultVo findCommentByGid(Integer gid) {
        List<CommentVo> list = commentVoService.findCommentByGid(gid);
        return ResultVo.setOK(list);
    }

    @ApiOperation(notes = "展示攻略相应评论", value = "展示攻略的评论")
    @RequestMapping("findStrategyComment.do")
    @ResponseBody
    public ResultVo findCommentBySid(Integer sid) {
        List<CommentVo> list = commentVoService.findCommentBySid(sid);
        return ResultVo.setOK(list);
    }

    @ApiOperation(notes = "添加评论", value = "添加评论")
    @RequestMapping("addComment.do")
    @ResponseBody
    public ResultVo addComment(Comment comment, String token) {
        return commentVoService.addCommentByGid(comment, token);
    }
}
