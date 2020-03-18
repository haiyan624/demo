package com.wq.mapper;

import java.util.Set;

public interface RoleMapper {
    Set<String> queryRolesByUsername(String username);
}
