package com.zhihui.service;

import com.zhihui.entity.User;
import com.zhihui.vo.ResultVo;

public interface UserService {

    ResultVo register(User user);

    ResultVo login(User user);

    ResultVo logout(String token);

    User findUNameById(Integer id);

    ResultVo updateNickname(String token, String name);
}