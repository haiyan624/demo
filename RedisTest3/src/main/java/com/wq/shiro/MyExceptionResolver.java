package com.wq.shiro;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println(ex.getClass());
        ex.printStackTrace();//开发时必需
        ModelAndView mv = new ModelAndView();
        if(ex instanceof IncorrectCredentialsException || ex instanceof UnknownAccountException){
            //跳转登录页面，重新登录
            mv.setViewName("redirect:/user/login/page");
        }else if(ex instanceof UnauthorizedException){// 角色不足  权限不足
            //跳转权限不足的页面
            mv.setViewName("redirect:/user/error");
        }else if(ex instanceof UnauthenticatedException){//没有登录 没有合法身份
            //跳转登录页面，重新登录
            mv.setViewName("redirect:/user/login/page");
        }
        return mv;
    }
}