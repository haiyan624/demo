import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wq.dao.UserInfoDao;
import wq.pojo.UserInfo;
import javax.annotation.Resource;
import java.util.Date;

//spring测试集成
//注⼊RedisTemplate，⾃动转换为对应Operation
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTest {
    @Resource(name = "redisTemplate")  //spring-data-redis 会⾃动 将RedisTemplate转换为  XXOperations
    private ValueOperations<String, Object> vo;
    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> lo;
    @Resource(name = "redisTemplate")
    private SetOperations<String, Object> so;
    @Resource(name = "redisTemplate")
    private ZSetOperations<String, Object> zo;
    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> ho;

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void test1() {
        vo.set("java", new UserInfo(1,"name","password","salt", new Date()));
        UserInfo user = (UserInfo) vo.get("java");
        System.out.println(user);
        lo.leftPush("list", new UserInfo(1,"name1","password1","salt1", new Date()));
        so.add("set", new UserInfo(4,"name4","password4","salt4", new Date()));
        zo.add("zset", new UserInfo(2,"name2","password2","salt2", new Date()), 1);
        ho.put("hash", "user", new UserInfo(3,"name3","password3","salt3", new Date()));
        vo.set("aa","bb");
        System.out.println(vo.get("aa"));
        System.out.println(userInfoDao.selectAll());
    }
}
