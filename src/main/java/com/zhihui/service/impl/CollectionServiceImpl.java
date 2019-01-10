package com.zhihui.service.impl;

import com.zhihui.dao.CollectionMapper;
import com.zhihui.entity.Goods;
import com.zhihui.service.CollectiongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectiongService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public List<Goods> findCollById(Integer uid) {
        List<Goods> list = collectionMapper.findCollectById(uid);

        return list;
    }
}
