package org.zheng.sand.login.dao;

import org.zheng.sand.login.entity.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(String uid);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
}