package com.zhihui.controller;

import com.tools.vo.PageBeanVo;
import com.zhihui.dao.StrategyMapper;
import com.zhihui.entity.Strategy;
import com.zhihui.service.StrategyService;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(produces = "攻略展示接口", value = "攻略")
@RestController
public class StrategyController {
    @Autowired
    private StrategyMapper strategyMapper;

    @Autowired
    private StrategyService strategyService;

    @ApiOperation(notes = "攻略详情" ,value = "攻略详情")
    @GetMapping("findOneStrategyById.do")
    public ResultVo findOneStrategyById(Integer id){
        Strategy stratey = strategyMapper.findOneStratey(id);
        return ResultVo.setOK(stratey);
    }

    @ApiOperation(notes = "通过页码和每页显示数量展示攻略", value = "展示攻略接口")
    @GetMapping("showAllStrategy.do")
    public PageBeanVo showAllStrategy(Integer page, Integer limit){
        return strategyService.showAllStrategy(page,limit);
    }
}
