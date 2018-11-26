package org.zheng.sand.login.service;

import org.zheng.sand.login.entity.UserLogin;

public interface LoginService {
    public boolean login(UserLogin userLogin);

    public int addUser(UserLogin userLogin);

    public int deleteUserLogin(String infoId);
}
