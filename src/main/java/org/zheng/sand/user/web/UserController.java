package org.zheng.sand.user.web;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zheng.sand.common.Response;
import org.zheng.sand.login.entity.UserLogin;
import org.zheng.sand.login.service.LoginService;
import org.zheng.sand.user.entity.UserInfo;
import org.zheng.sand.user.service.UserService;

/**
 * project:sand
 * author:zhengguocchun
 * date:2018/11/23
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {
    private static final String ADDUSERERRORCODE    =  "-2";
    private static final String SUCCESSCODE          =  "0";
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(UserInfo userInfo, UserLogin userLogin) {
        Response response = new Response();
        String msg = "";
        int info_code = 0;
        int login_code = 0;
        int infoLine = userService.addUserInfo(userInfo);
        if (infoLine == 0) {
            msg += "add user info failed :(!+";
            info_code = -1;
        }
        int loginLine = loginService.addUser(userLogin);
        if (loginLine == 0) {
            msg += "add user login info failed :(!";
            login_code = -1;
        }

        if(info_code == -1 || login_code == -1) {
            response.setCode(ADDUSERERRORCODE);
            response.setMsg(msg);
        }else{
            response.setCode(SUCCESSCODE);
            response.setMsg(msg);
        }
        return JSON.toJSONString(response);
    }
}
