package com.zhihui.service;

import com.zhihui.entity.User;
import com.zhihui.vo.ResultVo;

public interface UserService {

    ResultVo register(User user);
}