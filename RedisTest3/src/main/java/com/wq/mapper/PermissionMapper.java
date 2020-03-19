package com.wq.mapper;

import java.util.Set;

public interface PermissionMapper {
    Set<String> queryPermissionsByUsername(String username);
}
