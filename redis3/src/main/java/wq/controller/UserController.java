package wq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wq.pojo.UserInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/getall",method = RequestMethod.GET)
    public String getAll(Model model){
        List<UserInfo> list =new ArrayList<>();
        UserInfo userInfo = new UserInfo(1, "name", "password", "salt", new Date());
        list.add(userInfo);
        model.addAttribute("users",list);
        return "forward:WEB-INF/user/users.jsp";
    }
}
