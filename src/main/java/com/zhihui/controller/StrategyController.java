package com.zhihui.controller;

import com.zhihui.dao.StrategyMapper;
import com.zhihui.entity.Strategy;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrategyController {
    @Autowired
    private StrategyMapper strategyMapper;

    @ApiOperation(notes = "攻略详情" ,value = "攻略详情")
    @RequestMapping("findOneStrategyById.do")
    public ResultVo findOneStrategyById(Integer id){
        Strategy stratey = strategyMapper.findOneStratey(id);
        return ResultVo.setOK(stratey);
    }
}
