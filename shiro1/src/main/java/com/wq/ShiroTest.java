package com.wq;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroTest {
    public static void main(String[] args) {
        // 定义main函数测试效果
        // 创建 "SecurityFactory",加载ini配置,并通过它创建SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        // 将SecurityManager托管到SecurityUtils工具类中(ops:之后可以不必关心SecurityManager)
        SecurityUtils.setSecurityManager(securityManager);

        // 获得Subject，通过subject可以执行shiro的相关功能操作(身份认证或权限校验等)
        Subject currentUser = SecurityUtils.getSubject();

        // 身份认证( 类似登录逻辑 )
        if (!currentUser.isAuthenticated()) {//判断是否已经登录
            //如果未登录，则封装一个token，其中包含 用户名和密码
            UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
            try {
                //将token传入login方法，进行身份认证 (判断用户名和密码是否正确)
                currentUser.login(token);//如果失败则会抛出异常
            } catch (UnknownAccountException uae) {//用户不存在
                System.out.println("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {//密码错误
                System.out.println("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {//账户冻结，手动抛出
                System.out.println("The account for username " + token.getPrincipal() + " is locked.  "
                        + "Please contact your administrator to unlock it.");
            } catch (AuthenticationException ae) {//其他认证异常

            }
        }

        // 认证成功则用户信息会存入 currentUser（Subject）
        System.out.println("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        // 可以进一步进行角色校验 和 权限校验
        if (currentUser.hasRole("admin")) { //校验角色
            System.out.println("hello,boss");
        } else {
            System.out.println("Hello, you");
        }
        if (currentUser.isPermitted("user:update")) { //校验权限
            System.out.println("you can update user");
        } else {
            System.out.println("Sorry, you can not update.");
        }

        // 用户退出，会清除用户状态，身份信息，登录状态信息，权限信息，角色信息，会话信息，全部抹除
        currentUser.logout();

        // System.exit(0);

    }
}
