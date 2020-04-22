package com.wq.client.controller;

import com.wq.client.entity.User;
import com.wq.client.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class UserController {
    @Autowired
    private UserFeignClient userFeignClient;
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        User user = this.userFeignClient.findById(id);
        return user;
    }
}
