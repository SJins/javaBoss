package com.zhihui.service;

import com.zhihui.entity.UserDetail;
import com.zhihui.vo.ResultVo;

public interface UserDetailService {

    ResultVo myselfMsg(String token);

    ResultVo updateMsg(String token, UserDetail userDetail);
}
