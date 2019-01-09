package com.zhihui.service.impl;

import com.zhihui.dao.UserDetailMapper;
import com.zhihui.entity.User;
import com.zhihui.entity.UserDetail;
import com.zhihui.service.UserDetailService;
import com.zhihui.token.Token;
import com.zhihui.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailMapper userDetailMapper;
    @Override
    public ResultVo myselfMsg(String token) {
        User user = Token.token.get(token);
        return ResultVo.setOK(userDetailMapper.selectByUid(user.getId()));
    }
}
