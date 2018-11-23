package org.zheng.sand.user.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zheng.sand.user.dao.UserInfoMapper;
import org.zheng.sand.user.entity.UserInfo;
import org.zheng.sand.user.service.UserService;

/**
 * project:sand
 * author:zhengguocchun
 * date:2018/11/23
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }
}
