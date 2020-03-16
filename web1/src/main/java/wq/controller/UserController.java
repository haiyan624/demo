package wq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wq.dao.UserInfoDao;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoDao userInfoDao;

    @Resource(name = "redisTemplate")  //spring-data-redis 会⾃动 将RedisTemplate转换为  XXOperations
    private ValueOperations<String, Object> vo;

    @RequestMapping(value = "/getall",method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("users",userInfoDao.selectAll());
        System.out.println(vo.get("aa"));
        return "WEB-INF/user/users";
    }
}
