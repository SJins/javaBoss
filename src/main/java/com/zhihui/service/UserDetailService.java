package com.zhihui.service;

import com.zhihui.entity.UserDetail;
import com.zhihui.vo.ResultVo;

import java.util.Date;

public interface UserDetailService {

    ResultVo myselfMsg(String token);

    // 修改头像
    ResultVo updateMsg(String token, String headImg);
    //根据用户id,查找与用户的个人资料信息
    public  UserDetail findOneDetail(Integer id);

    ResultVo updateSexAndBirthday(String token, Integer sex, Date birthday);
}
