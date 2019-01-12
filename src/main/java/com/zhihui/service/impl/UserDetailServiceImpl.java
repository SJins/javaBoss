package com.zhihui.service.impl;

import com.zhihui.dao.UserDetailMapper;
import com.zhihui.entity.User;
import com.zhihui.entity.UserDetail;
import com.zhihui.service.UserDetailService;
import com.zhihui.token.Token;
import com.zhihui.vo.PersonalData;
import com.zhihui.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public ResultVo myselfMsg(String token) {
        User user = Token.token.get(token);
        PersonalData data = userDetailMapper.selectByUid(user.getId());
        return ResultVo.setOK(data);
    }

    @Override
    public ResultVo updateMsg(String token, String headImg) {
        User user = Token.token.get(token);
        UserDetail userDetail = userDetailMapper.selectUserDetailByUid(user.getId());

        if (userDetail!=null) {
            userDetail.setImg(headImg);
            if (userDetailMapper.updateByUidSelective(userDetail) > 0) {
                return ResultVo.setOK("修改成功");
            }
        }
        return ResultVo.setERROR();
    }

    @Override
    public UserDetail findOneDetail(Integer id) {
        UserDetail detail = userDetailMapper.findOneDetail(id);
        return detail;
    }

    @Override
    public ResultVo updateSexAndBirthday(String token, Integer sex, Date birthday) {
        User user = Token.token.get(token);
        UserDetail userDetail = userDetailMapper.selectUserDetailByUid(user.getId());
        if(userDetail!=null){
            userDetail.setBirthday(birthday);
            userDetail.setSex(sex);
            if(userDetailMapper.updateByUidSelective(userDetail)>0){
                return ResultVo.setOK("修改成功");
            }
        }
        return ResultVo.setERROR();
    }
}
