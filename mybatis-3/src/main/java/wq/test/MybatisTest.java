package wq.test;

import org.apache.ibatis.session.SqlSession;
import wq.dao.UserInfoDao;
import wq.util.MyBatisUtils;

public class MybatisTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserInfoDao mapper = sqlSession.getMapper(UserInfoDao.class);
        System.out.println(mapper.selectAll());
    }
}
