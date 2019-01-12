package com.zhihui.service.impl;



import com.zhihui.dao.CommentMapper;
import com.zhihui.dao.ReplyMapper;
import com.zhihui.dao.UserDetailMapper;
import com.zhihui.dao.UserMapper;
import com.zhihui.entity.Comment;
import com.zhihui.entity.Reply;
import com.zhihui.entity.User;
import com.zhihui.service.CommentVoService;
import com.zhihui.vo.CommentVo;
import com.zhihui.vo.PersonalData;
import com.zhihui.vo.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsCommentServiceImpl implements CommentVoService {

    @Autowired
    private CommentMapper commentDao;

    @Autowired
    private UserDetailMapper userDetailDao;

    @Autowired
    private UserMapper userDao;

    @Autowired
    private ReplyMapper replyDao;




    @Override
    public List<CommentVo> findCommentByGid(Integer gid) {
        List<Comment> comment = commentDao.findCommentByGid(gid);
        int commentnum = comment.size();
        List<CommentVo> list = new ArrayList<>();

        for (Comment comments: comment
        ) {
            PersonalData userDeta = userDetailDao.selectByUid(comments.getUid());
            User user = userDao.findUNameById(comments.getId());
            CommentVo commentVo = new CommentVo();

            commentVo.setId(comments.getId());
            commentVo.setContent(comments.getContent());
            commentVo.setImg(userDeta.getImg());
            commentVo.setName(user.getName());

            // 显示相应时间
            Date now = new Date();
            String datePoor = getDatePoor(now, comments.getCommentTime());

            commentVo.setCommentTime(datePoor);

            List<Reply> replies = replyDao.findReplyByCid(comments.getId());

            List<ReplyVo> rList = new ArrayList<>();
            for (Reply reply: replies
            ) {
                ReplyVo replyVo = new ReplyVo();

                replyVo.setId(reply.getId());
                Reply reply1 = replyDao.selectByPrimaryKey(reply.getParentid());
                User user1 = userDao.findUNameById(reply.getUid());
                User user2 = userDao.findUNameById(reply1.getUid());

                replyVo.setName(user1.getName());
                replyVo.setRname(user2.getName());

                // 显示相应时间
                Date nows = new Date();
                String datePoors = getDatePoor(nows, reply.getReplyTime());
                replyVo.setReplyTime(datePoors);

                replyVo.setRcontent(reply.getRcontent());
                rList.add(replyVo);
            }

            commentVo.setReplys(rList);
            commentVo.setCommentnum(commentnum);
            list.add(commentVo);

        }


        return list;
    }

    @Override
    public List<CommentVo> findCommentBySid(Integer sid) {
        List<Comment> comment = commentDao.findCommentBySid(sid);

        int commentnum = comment.size();
        List<CommentVo> list = new ArrayList<>();

        for (Comment comments: comment
        ) {
            PersonalData userDeta = userDetailDao.selectByUid(comments.getUid());
            User user = userDao.findUNameById(comments.getId());
            CommentVo commentVo = new CommentVo();

            commentVo.setId(comments.getId());
            commentVo.setContent(comments.getContent());
            commentVo.setImg(userDeta.getImg());
            commentVo.setName(user.getName());

            // 显示相应时间
            Date now = new Date();
            String datePoor = getDatePoor(now, comments.getCommentTime());

            commentVo.setCommentTime(datePoor);

            List<Reply> replies = replyDao.findReplyByCid(comments.getId());

            List<ReplyVo> rList = new ArrayList<>();
            for (Reply reply: replies
            ) {
                ReplyVo replyVo = new ReplyVo();

                replyVo.setId(reply.getId());
                Reply reply1 = replyDao.selectByPrimaryKey(reply.getParentid());
                User user1 = userDao.findUNameById(reply.getUid());
                User user2 = userDao.findUNameById(reply1.getUid());

                replyVo.setName(user1.getName());
                replyVo.setRname(user2.getName());

                // 显示相应时间
                Date nows = new Date();
                String datePoors = getDatePoor(nows, reply.getReplyTime());
                replyVo.setReplyTime(datePoors);

                replyVo.setRcontent(reply.getRcontent());
                rList.add(replyVo);
            }

            commentVo.setReplys(rList);
            commentVo.setCommentnum(commentnum);
            list.add(commentVo);

        }


        return list;
    }


    /**
     * 计算对应的时间差
     * @param beginDate
     *              现在的时间
     * @param endDate
     *              上架时间
     * @return
     *      String类型
     */
    private String getDatePoor(Date beginDate, Date endDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = 0;

        diff = beginDate.getTime()  - (endDate.getTime()- (8 * nh));


        long day = diff / nd;
        long h = diff / nh;
        long s = diff / ns;
        long m = diff / nm;


        if (s < 60) {
            return s + "秒前";
        } else if (s >= 60 && m < 60) {
            return m + "分钟前";
        } else if (m >= 60 && h < 24 ) {
            return h + "小时前";
        } else if (h >= 24 && day < 3) {
            return day + "天前";
        } else {
            long begin = beginDate.getTime();
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String times = time.format(begin);
            return times;
        }

    }
}
