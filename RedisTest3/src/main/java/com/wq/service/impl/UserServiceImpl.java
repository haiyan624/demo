package com.wq.service.impl;

import com.wq.entity.User;
import com.wq.mapper.PermissionMapper;
import com.wq.mapper.RoleMapper;
import com.wq.mapper.UserMapper;
import com.wq.service.UserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User registUser(User user) {
        String hashAlgorithmName = "SHA-256";
        int hashIterations = 1000;


        user.setSalt(UUID.randomUUID().toString());//设置随机盐
        //设置加密属性：sha256算法，随机盐，迭代1000次
        Sha256Hash sha256Hash = new Sha256Hash(user.getPassword(), user.getSalt(), hashIterations);
        // 另一种加密情况
//        SimpleHash sha256Hash2 = new SimpleHash(hashAlgorithmName, user.getPassword(), user.getSalt(), hashIterations);

        //将用户信息 (包括密码的密文 和 盐) 存入数据库
        user.setPassword(sha256Hash.toBase64());//密文采用base64格式化

//        String password="abc";//密码明文
//        String salt=UUID.randomUUID().toString();//盐
//        Integer iter = 1000;//迭代次数
//        String pwd = new Md5Hash(password, salt,iter).toString(); //md5加密
//        String pwd = new Md5Hash(password, salt, iter).toBase64(); //加密后转base64
//
//        String pwd = new Sha256Hash(password, salt, iter).toString();//sha256加密
//        String pwd = new Sha256Hash(password, salt, iter).toBase64();//加密后转base64
//
//        String pwd = new Sha512Hash(password, salt, iter).toString();//sha256加密
//        String pwd = new Sha512Hash(password, salt, iter).toBase64()//加密后转base64
        userMapper.insert(user);
        return user;
    }

    @Override
    public User queryUser(String username) {
        return userMapper.queryUserByUserName(username);
    }

    @Override
    public Set<String> queryRolesByUsername(String username) {
        return roleMapper.queryRolesByUsername(username);
    }

    @Override
    public Set<String> queryPermissionsByUsername(String username) {
        return permissionMapper.queryPermissionsByUsername(username);
    }
}
