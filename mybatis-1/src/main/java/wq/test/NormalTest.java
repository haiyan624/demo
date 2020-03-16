package wq.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import wq.pojo.UserInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class NormalTest {
    public static void main(String[] args) {
        NormalTest test = new NormalTest();
        test.test1();
    }

    public void test1() {
        //1.读取mybatis的配置文件
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建sqlSessionFactory() 可以理解为java程序与数据库之间的连接
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //3.获取SqlSession（通过工厂获取连接）
            sqlSession = factory.openSession();
            //4.执行
            List<UserInfo> userInfos = sqlSession.selectList("wq.dao.UserInfoDao.selectAll");
            for (UserInfo userInfo : userInfos) {
                System.out.println(userInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
}
