package com.zhihui.dao;

import com.zhihui.entity.Strategy;
import com.zhihui.vo.StrategyVO;

import java.util.List;

public interface StrategyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Strategy record);

    int insertSelective(Strategy record);

    Strategy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Strategy record);

    int updateByPrimaryKey(Strategy record);

    //根据攻略的id,查找攻略的详情信息
    public Strategy findOneStratey(Integer id);

    List<StrategyVO> selectAllStrategy();

}