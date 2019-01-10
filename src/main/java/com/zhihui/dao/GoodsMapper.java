package com.zhihui.dao;

import com.zhihui.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    /**
     * 分页查询对应商品
     * @param param
     * @return
     */
    List<Goods> selectByPage(Map<String,Object> param);

    /**
     * 查询商品数量
     * @return
     */
    int selectCount();

    /**
     * 根据id查询商品属性
     * @param id
     *         商品id
     * @return
     */
    Goods findGoodsPropertyById(Integer id);
}