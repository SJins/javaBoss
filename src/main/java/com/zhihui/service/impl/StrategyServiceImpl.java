package com.zhihui.service.impl;

import com.zhihui.dao.StrategyMapper;
import com.zhihui.entity.Strategy;
import com.zhihui.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    private StrategyMapper strategyMapper;

    @Override
    public Strategy fondOneStrateyBiId(Integer id) {
        Strategy stratey = strategyMapper.findOneStratey(id);
        return stratey;
    }
}
