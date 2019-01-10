package com.zhihui.service.impl;

import com.zhihui.dao.GoodsMapper;
import com.zhihui.dao.GoodsPropertyMapper;
import com.zhihui.entity.Goods;
import com.zhihui.entity.GoodsProperty;
import com.zhihui.service.GoodsService;
import com.zhihui.vo.PropertyVo;
import com.zhihui.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsDao;
    @Autowired
    private GoodsPropertyMapper goodsPropertyDao;

    @Override
    public ResultVo findGoodsProperty(Integer id) {

        // 获取对应商品
        Goods goods = goodsDao.findGoodsPropertyById(id);
        // 获取对应商品的属性
        List<GoodsProperty> properties = goods.getProperties();

        List<PropertyVo> list = new ArrayList<>();
       // 遍历商品属性
        for (GoodsProperty property: properties
             ) {
            PropertyVo property1 = new PropertyVo();
            if (property.getLevel() == 1) {
                property1.setPid(property.getPid());
                property1.setInfo(property.getInfo());
                property1.setChilds(new ArrayList<>());
                list.add(property1);
            } else {
                GoodsProperty properts = new GoodsProperty();
                properts.setPid(property.getPid());
                properts.setInfo(property.getInfo());
                properts.setParentId(property.getParentId());

                list.get(getGoodsPropertyIndex(properts.getParentId(), list)).getChilds().add(properts);

            }

        }
        return ResultVo.setOK(list);
    }

    // 查询对象
    private int getGoodsPropertyIndex(int id, List<PropertyVo> goodsProperty) {
        for (int i = 0; i < goodsProperty.size(); i++) {
            if (goodsProperty.get(i).getPid() == id) {
                return i;
            }
        }
        return -1;
    }
}
