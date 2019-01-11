package com.zhihui.service;

import com.github.pagehelper.Page;
import com.tools.vo.PageBeanVo;
import com.zhihui.vo.GoodsViewVo;

import java.util.List;

public interface GoodsViewVoService {

    /**
     * 分页查询对应
     * @param gtid
     *          商品类型id
     * @param page
     *          当前页数
     * @param limit
     *          每页数据条数
     * @return
     */
    PageBeanVo<GoodsViewVo> findgoodsView(Integer gtid, int page, int limit);

    /**
     * 根据商品名字进行模糊查询
     * @param goodsname
     *          商品模糊名字
     * @param page
     *          当前页
     * @param limit
     *          当前页数据条数
     * @return
     */
    PageBeanVo<GoodsViewVo> findGoodsView(String goodsname, int page, int limit);

    /**
     * 根据商品名字进行模糊查询
     * @param id
     *          商品id
     * @param page
     *          当前页
     * @param limit
     *          当前页数据条数
     * @return
     */
    /*PageBeanVo<> findGoodsViewById(Integer id, int page, int limit);*/
}
