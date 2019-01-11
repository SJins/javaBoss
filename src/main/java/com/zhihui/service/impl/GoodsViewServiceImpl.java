package com.zhihui.service.impl;

import com.tools.vo.PageBeanVo;
import com.zhihui.dao.GoodsMapper;
import com.zhihui.dao.GoodsimgsMapper;
import com.zhihui.entity.Goods;
import com.zhihui.entity.Goodsimgs;
import com.zhihui.service.GoodsViewVoService;
import com.zhihui.vo.GoodsViewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public PageBeanVo<GoodsViewVo> findgoodsView(Integer gtid, int page, int limit) {

        Map<String,Object> map = new HashMap();
        map.put("index",(page - 1) * limit);
        map.put("limit", limit);
        map.put("gtid", gtid);


        List<GoodsViewVo> list = ViewGoods(map);


        return PageBeanVo.setPage(goodsDao.selectCount(), list);
    }

    @Override
    /**
     * 根据商品名字进行模糊查询
     */
    public PageBeanVo<GoodsViewVo> findGoodsView(String goodsname, int page, int limit) {

        Map<String, Object> map = new HashMap<>();

        map.put("index", (page - 1) * limit);
        map.put("limit", limit);
        map.put("goodsname", goodsname);

        List<GoodsViewVo> list = ViewGoods(map);


        return PageBeanVo.setPage(goodsDao.selectCount(), list);
    }

    /*@Override*/
    /**
     * 根据商品id查询对应商品
     */
   /* public PageBeanVo<GoodsViewVo> findGoodsViewById(Integer id, int page, int limit) {
        Map<String, Object> map = new HashMap<>();

        map.put("index", (page - 1) * limit);
        map.put("limit", limit);
        map.put("id", id);

        List<GoodsViewVo> list = ViewGoods(map);

        return PageBeanVo.setPage(goodsDao.selectCount(), list);
    }*/

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

    private List<GoodsViewVo> ViewGoods(Map<String, Object> map) {

        // 根据菜单id查找对应的商品
        List<Goods> goodsList = goodsDao.selectByPage(map);

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
                view.setName(goods.getGoodsname());


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

                view.setPrice(goods.getPrice());

                float price = goods.getPrice();

                float discount = goods.getDiscount();

                // BigDecimal处理之后的价格
                BigDecimal prices = new BigDecimal(Float.toString(price));
                // BigDecimal处理之后的折扣
                BigDecimal discounts = new BigDecimal(Float.toString(discount));
                // BigDecimal处理之后的百分比
                BigDecimal percent = new BigDecimal(Float.toString(0.1F));
                // 折扣比例
                BigDecimal discountPercent = discounts.multiply(percent);
                // 折后价
                BigDecimal dPrice = prices.multiply(discountPercent);
                // 保留两位小数
                BigDecimal dPrices = dPrice.setScale(2, BigDecimal.ROUND_UP);
                view.setdPrice(dPrices);



                list.add(view);
            }

        }
        return list;
    }
}
