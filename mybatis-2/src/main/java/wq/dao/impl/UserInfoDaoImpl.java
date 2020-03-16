package wq.dao.impl;

import org.apache.ibatis.session.SqlSession;
import wq.dao.UserInfoDao;
import wq.pojo.UserInfo;
import wq.util.MyBatisUtils;

import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {
    public List<UserInfo> selectAll() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        List<UserInfo> list = sqlSession.selectList("selectAll");
        return list;
    }
}
