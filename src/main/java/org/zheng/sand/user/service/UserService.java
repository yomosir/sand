package org.zheng.sand.user.service;

import org.zheng.sand.user.entity.UserInfo;

public interface UserService {
    public int addUserInfo(UserInfo userInfo);

    public int updateUserInfo(UserInfo userInfo);

    public int deleteUserInfo(String id);
}
