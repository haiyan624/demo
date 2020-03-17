package com.wq.shiro;

import com.wq.entity.User;
import com.wq.service.UserService;
import lombok.Setter;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.context.ContextLoader;

import java.util.Set;

@Setter
public class MyRealm extends AuthorizingRealm {

    private UserService userService;


    /**
     * 是否支持某种token
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        System.out.println("is support in realm1");
        if (token instanceof UsernamePasswordToken) {
            return true;
        }
        return false;
    }

    /**
     * 当subject.login()时，shiro会调用Realm的此方法做用户信息的查询，然后做校验
     * 职责：通过用户传递来的用户名查询用户表，获得用户信息
     * 返回值：将查到的用户信息（用户名+密码）封装在AuthenticationInfo对象中返回
     * 异常：如果没有查到用户可抛出用户不存在异常；如果用户被锁定可抛出用户被锁异常；或其它自定义异常.
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获得用户名
        String username = (String) token.getPrincipal();
        System.out.println("user:" + username + " is authenticating~~");
        UserService userService =
                (UserService) ContextLoader.getCurrentWebApplicationContext().getBean("userService");
        //身份认证
        User user = userService.queryUser(username);
        System.out.println("user:" + user);
        /**
         如下代码可以省略，如果查询结果为空，直接返回null即可，
         shiro的后续流程已有类似判断逻辑，也会抛出UnknownAccountException
         if(user==null){//如果用户信息非法，则抛出异常
         System.out.println("用户不存在");
         throw new UnknownAccountException("username:"+username+"不存在");
         }
         **/
        //省略如上代码后，可以直接写：
        if (user == null) {
            return null;
        }
        // 将 当前用户的认证信息存入 SimpleAuthenticationInfo 并返回
        // 注意此方法的本职工作就是查询用户的信息，所以查到后不用比对密码是否正确，那是shiro后续流程的职责。
        // 如果密码错误，shiro的后续流程中会抛出异常IncorrectCredentialsException
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
        /**
         补充: 可以在user表中增加一列，用于存储用户是否被锁定，则查询的User对象中会有是否锁定的属性
         如果发现锁定则可以在此方法中抛出异常：LockedAccountException，
         **/
    }

    /**
     * 当触发权限或角色校验时：subject.isPermitted() / subject.checkPermission();
     * subject.hasRole() / subject.checkRole() 等。
     * 此时需要数据库中的 权限和角色数据，shiro会调用Realm的此方法来查询
     * 角色和权限信息存入SimpleAuthorizationInfo对象
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获得username
        String username = (String) principals.getPrimaryPrincipal();
        //新建SimpleAuthorizationInfo对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //查询当前用户的所有 "角色" 和 "权限"
        UserService userService =
                (UserService) ContextLoader.getCurrentWebApplicationContext().getBean("userService");
        Set<String> roles = userService.queryRolesByUsername(username);
        Set<String> perms = userService.queryPermissionsByUsername(username);
        //“角色” 和 “权限” 存入 SimpleAuthorizationInfo对象
        info.setRoles(roles);
        info.setStringPermissions(perms);
        //返回SimpleAuthorizationInfo
        return info;
    }
}
