package com.example.shiro550;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemoController {

    @PostMapping({"/doLogin"})
    public String doLoginPage(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(name = "rememberme", defaultValue = "") String rememberMe) {
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login((AuthenticationToken)new UsernamePasswordToken(username, password, rememberMe.equals("remember-me")));
        }catch (AuthenticationException e) {
            return "forward:/login";
        }
        return "forward:/";
    }

    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping({"/unauth"})
    public String errorPage(){
        return "error";
    }

    @RequestMapping({"/login"})
    public String loginPage() {
        return "login";
    }
}
