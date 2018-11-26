package org.zheng.sand.login.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zheng.sand.login.dao.UserLoginMapper;
import org.zheng.sand.login.entity.UserLogin;
import org.zheng.sand.login.service.LoginService;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public int deleteUserLogin(String infoId) {
        return userLoginMapper.deleteByInfoId(infoId);
    }

    @Override
    public boolean login(UserLogin userLogin) {
        Integer result = userLoginMapper.loginVerify(userLogin);
        if(result == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int addUser(UserLogin userLogin) {
        return userLoginMapper.insertSelective(userLogin);
    }
}
