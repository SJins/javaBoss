package com.zhihui.dao;

import com.zhihui.entity.User;
import com.zhihui.entity.UserDetail;
import com.zhihui.vo.PersonalData;

public interface UserDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Integer id);

    UserDetail selectUserDetailByUid(Integer id);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByUidSelective(UserDetail userDetail);

    int updateByPrimaryKey(UserDetail record);

    PersonalData selectByUid(Integer id);

    //根据用户id,显示个人资料信息
    public  UserDetail findOneDetail(Integer id);
}