package wq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wq.service.UserService;

import javax.annotation.Resource;

@Controller //声明这是一个控制器
@RequestMapping("/hello")  //访问路径 ，等价于url-pattern
public class HelloController {

	@Autowired UserService userService;

	@Resource(name = "redisTemplate")  //spring-data-redis 会⾃动 将RedisTemplate转换为  XXOperations
	private ValueOperations<String, Object> vo;

	@RequestMapping("/test1")  //访问路径
	public String hello1(){
		System.out.println("hello world");
		return "WEB-INF/user/index";
	}

	@RequestMapping(value = "test2" ,method = RequestMethod.GET)
	public String hello2(){
		System.out.println(userService.selectAll());
		System.out.println("-------");
		System.out.println(userService.selectAll());
		System.out.println(vo.get("aa"));
		return "WEB-INF/user/index";
	}
}
