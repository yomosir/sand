package org.zheng.sand.login.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zheng.sand.login.service.LoginService;

@RestController
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    public LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.PUT)
    public String login(@RequestParam String username,@RequestParam String password){
        boolean res = loginService.login(username,password);
        if(res){
            return "/admin/main";
        }else{

        }
        return null;
    }
}
