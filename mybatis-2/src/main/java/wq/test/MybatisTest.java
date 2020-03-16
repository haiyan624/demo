package wq.test;

import wq.dao.UserInfoDao;
import wq.dao.impl.UserInfoDaoImpl;

public class MybatisTest {
    public static void main(String[] args) {
        UserInfoDao dao = new UserInfoDaoImpl();
        System.out.println(dao.selectAll());
    }
}
