package com.zhihui.service;

import com.zhihui.vo.ResultVo;

public interface GoodsService {

    /**
     * 根据id查询商品属性
     * @param id
     * @return
     */
    ResultVo findGoodsProperty(Integer id);


}
