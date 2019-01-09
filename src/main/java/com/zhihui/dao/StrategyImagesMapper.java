package com.zhihui.dao;

import com.zhihui.entity.StrategyImages;

public interface StrategyImagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StrategyImages record);

    int insertSelective(StrategyImages record);

    StrategyImages selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StrategyImages record);

    int updateByPrimaryKey(StrategyImages record);
}