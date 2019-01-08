package com.zhihui.service.impl;

import com.zhihui.dao.GoodsTypeMapper;
import com.zhihui.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsDao;

    @Override
    public List<GoodsTypeService> findAll() {
        return null;
    }
}
