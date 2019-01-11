package com.zhihui.dao;

import com.zhihui.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByEmail(String email);
    //根据用户的id,修改昵称
//    public  void  updateName(Integer id);

    //根据用户id,绑定用户的名字信息
    public  User findUNameById(Integer id);
}