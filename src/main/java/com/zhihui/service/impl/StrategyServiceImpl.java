package com.zhihui.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tools.vo.PageBeanVo;
import com.zhihui.dao.StrategyMapper;
import com.zhihui.entity.Strategy;
import com.zhihui.service.StrategyService;
import com.zhihui.vo.StrategyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    private StrategyMapper strategyMapper;

    @Override
    public Strategy fondOneStrateyBiId(Integer id) {
        Strategy stratey = strategyMapper.findOneStratey(id);
        return stratey;
    }

    @Override
    public PageBeanVo<StrategyVO> showAllStrategy(Integer page, Integer limit) {
        Page<Object> pageInfo = PageHelper.startPage(page, limit);
        List<StrategyVO> strategyVOS = strategyMapper.selectAllStrategy();
        return PageBeanVo.setPage((int)pageInfo.getTotal(),strategyVOS);
    }
}
