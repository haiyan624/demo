package wq.dao;

import wq.pojo.UserInfo;

import java.util.List;

public interface UserInfoDao {
    List<UserInfo> selectAll();

    void insert(UserInfo userInfo);
}
