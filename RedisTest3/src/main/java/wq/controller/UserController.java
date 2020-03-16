package wq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wq.dao.UserInfoDao;
import wq.pojo.UserInfo;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoDao userInfoDao;

    @Resource(name = "redisTemplate")  //spring-data-redis 会⾃动 将RedisTemplate转换为  XXOperations
    private ValueOperations<String, Object> vo;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("users", userInfoDao.selectAll());
        return "WEB-INF/user/users";
    }

    @RequestMapping(value = "/registPage", method = RequestMethod.GET)
    public String registPage() {
        return "WEB-INF/user/regist";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(@RequestBody UserInfo userInfo) {
        userInfo.setCreateDate(new Date());
        userInfo.setSalt(UUID.randomUUID().toString());
        userInfoDao.insert(userInfo);
        System.out.println("注册成功，新增用户id为："+userInfo.getId());
        return "WEB-INF/user/index";
    }
}
