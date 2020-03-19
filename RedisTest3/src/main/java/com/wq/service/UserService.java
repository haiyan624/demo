package com.wq.service;

import com.wq.entity.User;

import java.util.Set;

public interface UserService {
    User registUser(User user);

    User queryUser(String username);

    Set<String> queryRolesByUsername(String username);

    Set<String> queryPermissionsByUsername(String username);
}
