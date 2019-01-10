package com.zhihui.dao;

import com.zhihui.entity.GoodsProperty;

public interface GoodsPropertyMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(GoodsProperty record);

    int insertSelective(GoodsProperty record);

    GoodsProperty selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(GoodsProperty record);

    int updateByPrimaryKey(GoodsProperty record);
}