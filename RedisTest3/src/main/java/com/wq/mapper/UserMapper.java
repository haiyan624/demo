package com.wq.mapper;

import com.wq.entity.User;

public interface UserMapper {

    User queryUserByUserName(String username);

    Integer insert(User user);

}

