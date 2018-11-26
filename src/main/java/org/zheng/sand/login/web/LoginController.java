package org.zheng.sand.login.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zheng.sand.common.Md5Encryption;
import org.zheng.sand.common.Response;
import org.zheng.sand.login.entity.UserLogin;
import org.zheng.sand.login.service.LoginService;

import java.util.Collections;

@RestController
@Component
@EnableAutoConfiguration
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private LoginService loginService;
    private static final String LOGINERRORCODE    =    "-1";
    private static final String SUCCESSCODE       =     "0";

    @RequestMapping(value = "/login",method = RequestMethod.PUT)
    public String login(@RequestParam String username,@RequestParam String password){
        Response response = new Response();
        UserLogin userLogin = new UserLogin();
        userLogin.setUname(username);
        userLogin.setPasswd(Md5Encryption.encryptPassword(password));
        boolean res = loginService.login(userLogin);
        if(res){
            response.setData("");
            response.setCode(SUCCESSCODE);
            response.setMsg(Collections.singletonList("ok"));
        }else{
            response.setData("");
            response.setCode(LOGINERRORCODE);
            response.setMsg(Collections.singletonList("error"));
        }
        return JSONObject.toJSONString(response);
    }
}
