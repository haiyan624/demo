package wq.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
//注意导包别导错了

public class MyBatisUtils {
	public  static SqlSessionFactory factory;
	static{
		try {
			//获取流
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//FactoryBuilder
			factory=new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSession openSession(){
		return factory.openSession();
	}
}
