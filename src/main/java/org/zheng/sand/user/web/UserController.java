package org.zheng.sand.user.web;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zheng.sand.common.Md5Encryption;
import org.zheng.sand.common.Response;
import org.zheng.sand.common.ResponseUtil;
import org.zheng.sand.login.entity.UserLogin;
import org.zheng.sand.login.service.LoginService;
import org.zheng.sand.user.entity.UserInfo;
import org.zheng.sand.user.service.UserService;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * project:sand
 * author:zhengguocchun
 * date:2018/11/23
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {
    private static final int ADDUSERINFOERRORCODE  =   1002;
    private static final int ADDUSERERRORCODE  =   1006;
    private static final int UPDATEUSERINFOFAILEDCODE    =   1003;
    private static final int DELETEUSERLOGINFAILEDCODE   =   1004;
    private static final int DELETEUSERINFOFAILEDCODE    =   1005;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Response addUser(UserInfo userInfo, UserLogin userLogin) {
        /* 设置login的id主键和info的id主键 */
        String info_id = UUID.randomUUID().toString();
        String login_id = UUID.randomUUID().toString();
        userInfo.setUiId(info_id);
        userLogin.setInfoId(info_id);
        userLogin.setUid(login_id);
        /* 处理密码，对密码进行加密 */
        userLogin.setPasswd(Md5Encryption.encryptPassword(userLogin.getPasswd()));
        Response response = new Response();
        List<String> msg = new LinkedList<>();
        int info_code = 0;
        int login_code = 0;
        int infoLine = userService.addUserInfo(userInfo);
        if (infoLine == 0) {
            return ResponseUtil.error(ADDUSERINFOERRORCODE,"add user info failed");
        }
        int loginLine = loginService.addUser(userLogin);
        if (loginLine == 0) {
            return ResponseUtil.error(ADDUSERERRORCODE,"add user failed");
        }
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/updateUserInfo")
    public Response updateUserInfo(UserInfo userInfo){
        Response response = new Response();
        int lines = userService.updateUserInfo(userInfo);
        if (lines == 0){
           return ResponseUtil.error(UPDATEUSERINFOFAILEDCODE,"update user info failed :(");
        }else{
            return ResponseUtil.success();
        }
    }

    public Response deleteUser(UserInfo userInfo){
        Response response = new Response();
        /* 先获取info id，以便于稍后删除登录信息 */
        String info_id = userInfo.getUiId();
        /* 先删除login，再删除info相关信息 */
        int lines = loginService.deleteUserLogin(info_id);
        if(lines == 0){
            return ResponseUtil.error(DELETEUSERLOGINFAILEDCODE,"delete user login failed :(");
        }
        lines = userService.deleteUserInfo(info_id);
        if(lines == 0){
            return ResponseUtil.error(DELETEUSERINFOFAILEDCODE,"delete user info failed :(");
        }
        return ResponseUtil.success();
    }
}
