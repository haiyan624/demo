package wq.service;

import wq.pojo.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> selectAll();
}
