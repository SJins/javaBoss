package com.zhihui.dao;

import com.zhihui.entity.GGoodsProperty;

public interface GGoodsPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GGoodsProperty record);

    int insertSelective(GGoodsProperty record);

    GGoodsProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GGoodsProperty record);

    int updateByPrimaryKey(GGoodsProperty record);
}