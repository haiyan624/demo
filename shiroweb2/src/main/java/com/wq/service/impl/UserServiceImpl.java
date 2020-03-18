package com.wq.service.impl;

import com.wq.entity.Role;
import com.wq.entity.User;
import com.wq.mapper.PermissionMapper;
import com.wq.mapper.RoleMapper;
import com.wq.mapper.UserMapper;
import com.wq.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
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
        String salt = UUID.randomUUID().toString();
        int hashIterations = 1000;
//        String password = new SimpleHash(hashAlgorithmName, ByteSource.Util.bytes(), salt, hashIterations).toHex();
        String password = new SimpleHash(hashAlgorithmName, user.getPassword(), salt, hashIterations).toBase64();
        user.setPassword(password);
        user.setSalt(salt);
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
