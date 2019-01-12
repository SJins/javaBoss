package com.zhihui.service.impl;

import com.zhihui.dao.CollectionMapper;
import com.zhihui.entity.Collection;
import com.zhihui.entity.Goods;
import com.zhihui.entity.Strategy;
import com.zhihui.entity.User;
import com.zhihui.service.CollectiongService;
import com.zhihui.token.Token;
import com.zhihui.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public List<Strategy> findCollStraById(Integer id) {
        List<Strategy> list = collectionMapper.findCollStraById(id);
        return list;
    }

    @Override
    public ResultVo addStrategyToCollection(String token, Integer id) {
        User user = Token.token.get(token);
        Collection collection = new Collection();
        collection.setCollectiontime(new Date());
        collection.setSid(id);
        collection.setUid(user.getId());
        if(collectionMapper.insertSelective(collection)>0){
            return ResultVo.setOK("收藏成功");
        }
        return ResultVo.setERROR();
    }

    @Override
    public ResultVo addGoodsToCollection(String token, Integer id) {
        User user = Token.token.get(token);
        Collection collection = new Collection();
        collection.setCollectiontime(new Date());
        collection.setGid(id);
        collection.setUid(user.getId());
        if(collectionMapper.insertSelective(collection)>0){
            return ResultVo.setOK("收藏成功");
        }
        return ResultVo.setERROR();
    }
}
