package com.zhihui.service.impl;

import com.zhihui.dao.GoodsMapper;
import com.zhihui.dao.GoodsimgsMapper;
import com.zhihui.entity.Goods;
import com.zhihui.entity.Goodsimgs;
import com.zhihui.service.GoodsMessageService;
import com.zhihui.vo.GoodsMessageVo;
import com.zhihui.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsMessageServiecImpl implements GoodsMessageService {

    @Autowired
    private GoodsMapper goodsDao;

    @Autowired
    private GoodsimgsMapper goodsimgsDao;

    @Override
    /**
     * 根据商品id查找商品信息
     */
    public ResultVo findGoodsMessageById(Integer id) {

        // 根据id查找商品
        Goods goods = goodsDao.selectByPrimaryKey(id);
        // 根据商品id查找商品图片
        List<Goodsimgs> allImg = goodsimgsDao.findAllImg(id);

        List<GoodsMessageVo> list = new ArrayList<>();
        GoodsMessageVo messageVo = new GoodsMessageVo();





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
        messageVo.setdPrice(dPrices);
        messageVo.setGoods(goods);
        messageVo.setGoodsimgs(allImg);

        return ResultVo.setOK(messageVo);
    }
}
