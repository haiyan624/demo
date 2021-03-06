package com.wq.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class ShiroController {
    @RequestMapping("/auth")
    public String deleteUser() {//访问此删除功能时要先经过shiro的安全校验
        return "WEB-INF/user/authCheck";
    }

    @RequestMapping(value = "/login/logic", method = RequestMethod.GET)
    public String login(String username, String password) {//登录功能不能被shiro校验，否则永不能登录
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username, password));
            String uname = (String) subject.getPrincipal();
            System.out.println("uname:" + uname);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "WEB-INF/user/login.jsp";
        }
        return "WEB-INF/user/success";
    }
}

