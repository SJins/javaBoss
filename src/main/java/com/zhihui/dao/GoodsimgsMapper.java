package com.zhihui.dao;

import com.zhihui.entity.Goodsimgs;

import java.util.List;

public interface GoodsimgsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goodsimgs record);

    int insertSelective(Goodsimgs record);

    Goodsimgs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goodsimgs record);

    int updateByPrimaryKey(Goodsimgs record);

    /**
     * 根据商品id查找对应图片
     * @param gid
     *      商品id
     * @return
     */
    List<Goodsimgs> findAllImg(Integer gid);
}