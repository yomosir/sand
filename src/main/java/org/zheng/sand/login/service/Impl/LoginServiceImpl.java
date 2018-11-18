package org.zheng.sand.login.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zheng.sand.login.dao.UserLoginMapper;
import org.zheng.sand.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public boolean login(String username, String password) {
        int result = userLoginMapper.loginVerify(username,password);
        if(result == 1){
            return true;
        }else{
            return false;
        }
    }
}
