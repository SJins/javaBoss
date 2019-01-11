package com.zhihui.service;

import com.zhihui.entity.UserDetail;
import com.zhihui.vo.ResultVo;

public interface UserDetailService {

    ResultVo myselfMsg(String token);

    ResultVo updateMsg(String token, UserDetail userDetail);
    //根据用户id,查找与用户的个人资料信息
    public  UserDetail findOneDetail(Integer id);
}
