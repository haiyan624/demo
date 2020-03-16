package wq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wq.dao.UserInfoDao;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoDao userInfoDao;

    @RequestMapping(value = "/getall",method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("users",userInfoDao.selectAll());
        return "forward:WEB-INF/user.jsp";
    }
}
