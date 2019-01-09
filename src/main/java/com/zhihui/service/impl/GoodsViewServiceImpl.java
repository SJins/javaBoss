package com.zhihui.service.impl;

import com.zhihui.dao.GoodsMapper;
import com.zhihui.dao.GoodsimgsMapper;
import com.zhihui.entity.Goods;
import com.zhihui.entity.Goodsimgs;
import com.zhihui.service.GoodsViewVoService;
import com.zhihui.vo.GoodsViewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsViewServiceImpl implements GoodsViewVoService {

    @Autowired
    private GoodsMapper goodsDao;
    @Autowired
    private GoodsimgsMapper goodsimgDao;

    @Override
    /**
     * 根据菜单id展示对应的商品
     */
    public List<GoodsViewVo> findgoodsView(Integer gtid) {
        // 根据菜单id查找对应的商品
        List<Goods> goodsList = goodsDao.findGoodsByGtid(gtid);

        List<GoodsViewVo> list = new ArrayList<>();
        // 遍历对应菜单的商品
        for (Goods goods : goodsList
             ) {
            // 商品flag为0时正常显示，为1时，已删除。
            if (goods.getFlag() != 1) {
                GoodsViewVo view = new GoodsViewVo();
                view.setCollectionnum(goods.getCollectionnum());
                view.setCommentnum(goods.getCommentnum());
                view.setDiscountdetail(goods.getDiscountdetail());
                view.setId(goods.getId());
                view.setName(goods.getName());

                Date now = new Date();
                String datePoor = getDatePoor(now, goods.getShelftime());

                view.setShelftime(datePoor);


                // 根据商品id获取对应的第一张图片
                List<Goodsimgs> allImg = goodsimgDao.findAllImg(goods.getId());
                for (Goodsimgs img : allImg
                ) {
                    if (img.getId() != 0) {
                        view.setImgurl(img.getImgUrl());
                    }
                    break;
                }



                list.add(view);
            }

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
        /* if(beginDate.after(endDate)) {*/
        diff = beginDate.getTime()  - (endDate.getTime()- (8 * nh));
        // }

    /*else {
    diff = endDate.getTime() - (beginDate.getTime() + (8 * nh));
    }*/

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
       /* // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        if (sec < 60) {
            return sec + "秒前";
        } else if (sec >= 60 && min < 60) {
            return min + "分钟前";
        } else if (min >= 60 && hour < 24) {
            return hour + "小时前";
        } else if (hour >= 24 && day < 3) {
            return day + "天前";
        } else {
            long begin = beginDate.getTime();
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String times = time.format(begin);
            return times;
        }*/
    }
}
