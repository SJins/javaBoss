package com.zhihui.dao;

import com.zhihui.entity.ReceivingDetail;

public interface ReceivingDetailMapper {
    int deleteByPrimaryKey(Integer id);

    //添加一个新地址
    public void insertRecDetail(ReceivingDetail receivingDetail);

    int insertSelective(ReceivingDetail record);

    ReceivingDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReceivingDetail record);

    int updateByPrimaryKey(ReceivingDetail record);
    
    //根据id查找我的收获地址详情
    public ReceivingDetail findOneRec(Integer uid);
}