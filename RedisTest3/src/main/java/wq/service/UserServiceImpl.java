package wq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wq.dao.UserInfoDao;
import wq.pojo.UserInfo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> selectAll() {
        List<UserInfo> userList = userInfoDao.selectAll();
        return userList;
    }
}
