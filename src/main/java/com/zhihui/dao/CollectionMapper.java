package com.zhihui.dao;

import com.zhihui.entity.Collection;
import com.zhihui.entity.Goods;
import com.zhihui.entity.Strategy;

import java.util.List;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);

    //根据用户id,查询商品收藏的信息
    public List<Goods> findCollectById(Integer uid);

    //根据用户id，查找用户收藏的攻略信息
    public List<Strategy> findCollStraById(Integer id);
}