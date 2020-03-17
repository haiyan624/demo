package com.wq.service.impl;

import com.wq.entity.User;
import com.wq.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User insertUser(User user) {
//        user.setSalt(UUID.randomUUID().toString());//设置随机盐
//        //设置加密属性：sha256算法，随机盐，迭代1000次
//        Sha256Hash sha256Hash = new Sha256Hash(user.getPassword(),user.getSalt(),1000);
//        //将用户信息 (包括密码的密文 和 盐) 存入数据库
//        user.setPassword(sha256Hash.toBase64());//密文采用base64格式化
//        userDAO.createUser(user);
        return null;
    }

    @Override
    public User queryUser(String username) {
        return null;
    }

    @Override
    public Set<String> queryRolesByUsername(String username) {
        return null;
    }

    @Override
    public Set<String> queryPermissionsByUsername(String username) {
        return null;
    }
}
