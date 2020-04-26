package com.wq.consumer.service;

import com.wq.dinterface.entity.UserAddress;
import com.wq.dinterface.service.OrderService;
import com.wq.dinterface.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference(loadbalance = "random", timeout = 1000, version = "1.0.0")
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id：" + userId);
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        return addressList;
    }

}