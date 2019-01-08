package com.qfedu.dao;

import com.qfedu.entity.GoodsProperty;

public interface GoodsPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsProperty record);

    int insertSelective(GoodsProperty record);

    GoodsProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsProperty record);

    int updateByPrimaryKey(GoodsProperty record);
}