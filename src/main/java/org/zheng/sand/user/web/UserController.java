package org.zheng.sand.user.web;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zheng.sand.common.Md5Encryption;
import org.zheng.sand.common.Response;
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
    private static final String ADDUSERERRORCODEFAILEDCODE  =   "-2";
    private static final String UPDATEUSERINFOFAILEDCODE    =   "-3";
    private static final String SUCCESSCODE                 =   "0";
    private static final String DELETEUSERLOGINFAILEDCODE   =   "-4";
    private static final String DELETEUSERINFOFAILEDCODE    =   "-5";
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(UserInfo userInfo, UserLogin userLogin) {
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
            msg.add("add user info failed");
            info_code = -1;
        }
        int loginLine = loginService.addUser(userLogin);
        if (loginLine == 0) {
            msg.add("add user info failed");
            login_code = -1;
        }

        if(info_code == -1 || login_code == -1) {
            response.setCode(ADDUSERERRORCODEFAILEDCODE);
            response.setMsg(msg);
        }else{
            response.setCode(SUCCESSCODE);
            response.setMsg(msg);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "/updateUserInfo")
    public String updateUserInfo(UserInfo userInfo){
        Response response = new Response();
        int lines = userService.updateUserInfo(userInfo);
        if (lines == 0){
            response.setCode(UPDATEUSERINFOFAILEDCODE);
            response.setMsg(Collections.singletonList("update user info failed :("));
        }else{
            response.setCode(SUCCESSCODE);
            response.setMsg(Collections.singletonList("update user info success :)"));
        }
        return JSON.toJSONString(response);
    }

    public String deleteUser(UserInfo userInfo){
        Response response = new Response();
        /* 先获取info id，以便于稍后删除登录信息 */
        String info_id = userInfo.getUiId();
        /* 先删除login，再删除info相关信息 */
        int lines = loginService.deleteUserLogin(info_id);
        if(lines == 0){
            response.setCode(DELETEUSERLOGINFAILEDCODE);
            response.setMsg(Collections.singletonList("delete user login failed :("));
            return JSON.toJSONString(response);
        }
        lines = userService.deleteUserInfo(info_id);
        if(lines == 0){
            response.setCode(DELETEUSERINFOFAILEDCODE);
            response.setMsg(Collections.singletonList("delete user info failed :("));
            return JSON.toJSONString(response);
        }
        response.setCode(SUCCESSCODE);
        response.setMsg(Collections.singletonList("delete user success :("));
        return JSON.toJSONString(response);
    }
}
