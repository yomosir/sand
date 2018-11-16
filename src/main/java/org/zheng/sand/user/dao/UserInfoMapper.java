package org.zheng.sand.user.dao;

import org.zheng.sand.user.entity.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String uiId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String uiId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}