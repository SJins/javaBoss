package com.zhihui.service.impl;

import com.tools.common.encrypt.EncryptUtil;
import com.zhihui.dao.UserMapper;
import com.zhihui.entity.User;
import com.zhihui.service.UserService;
import com.zhihui.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVo register(User user) {
        if (user != null) {
            user.setPassword(EncryptUtil.md5Enc(user.getPassword()));
            if (userMapper.insertSelective(user) > 0) {
                return ResultVo.setOK("注册成功");
            }
        }
        return ResultVo.setERROR();
    }
}
