package com.zhihui.service;

import com.zhihui.vo.ResultVo;

public interface ReceivingService {
    //根据用户id查找用户的收获详情
    public ResultVo findOneRec(Integer uid);
}
