package com.wq.controller;

import com.wq.entity.User;
import com.wq.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/user")
public class ShiroController {

    @Autowired
    private UserService userService;

    @RequiresPermissions("user:query")
    @RequestMapping("/auth")
    public String auth() {//访问此删除功能时要先经过shiro的安全校验
        return "WEB-INF/user/authCheck";
    }

    @RequiresRoles(value = {"admin","manager"},logical= Logical.OR)
    @RequestMapping("/success")
    public String success() {//访问此删除功能时要先经过shiro的安全校验
        return "WEB-INF/user/success";
    }

    @RequiresUser
    @RequestMapping("/success2")
    public String success2() {//访问此删除功能时要先经过shiro的安全校验
        return "WEB-INF/user/success";
    }

    @RequestMapping("/error")
    public String error() {//访问此删除功能时要先经过shiro的安全校验
        return "WEB-INF/user/error";
    }

    @RequestMapping("/login/page")
    public String login() {
        return "WEB-INF/user/login";
    }

    @RequestMapping(value = "/login/logic", method = RequestMethod.POST)
    public String logic(@ModelAttribute User user){//登录功能不能被shiro校验，否则永不能登录
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            //如果需要记住我的话，需要在token中设置
            token.setRememberMe(true);//shiro默认支持”记住我“，只要有此设置则自动运作。
            subject.login(token);
            String uname = (String) subject.getPrincipal();
            System.out.println("uname:" + uname);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "WEB-INF/user/login";
        }
        return "WEB-INF/user/success";
    }

    @RequestMapping(value="/regist", method = RequestMethod.GET)
    public String regist(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.registUser(user);
        return "WEB-INF/user/login";
    }
}

