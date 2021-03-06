package org.zheng.sand.login.dao;

import org.springframework.stereotype.Repository;
import org.zheng.sand.login.entity.UserLogin;
@Repository
public interface UserLoginMapper {
    int deleteByPrimaryKey(String uid);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);

    Integer loginVerify(UserLogin userLogin);
}