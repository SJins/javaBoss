package com.zhihui.service;

import com.tools.vo.PageBeanVo;
import com.zhihui.entity.Strategy;
import com.zhihui.vo.StrategyVO;

import java.util.List;

public interface StrategyService {
    //根据攻略的id,查找攻略详情信息
    public Strategy fondOneStrateyBiId(Integer id);

    // 根据传来的页码分页查找商品
    PageBeanVo<StrategyVO> showAllStrategy(Integer page, Integer limit);
}
