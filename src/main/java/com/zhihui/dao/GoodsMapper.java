package com.zhihui.dao;

import com.zhihui.entity.Goods;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> findGoodsByGtid(Integer gtid);
}