package org.zheng.sand.login.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zheng.sand.common.Response;
import org.zheng.sand.login.entity.UserLogin;
import org.zheng.sand.login.service.LoginService;

@RestController
@Component
@EnableAutoConfiguration
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    public LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.PUT)
    public String login(@RequestParam String username,@RequestParam String password){
        Response response = new Response();
        UserLogin userLogin = new UserLogin();
        userLogin.setUname(username);
        userLogin.setPasswd(password);
        boolean res = loginService.login(userLogin);
        if(res){
            response.setData("login success");
            response.setErr_code("0");
            response.setErr_msg("ok");
        }else{
            response.setData("login failed");
            response.setErr_code("-1");
            response.setErr_msg("error");
        }
        return JSONObject.toJSONString(response);
    }
}
