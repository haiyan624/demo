package com.wq.consumer.service;

import com.wq.dinterface.entity.UserAddress;
import com.wq.dinterface.service.OrderService;
import com.wq.dinterface.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id：" + userId);
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        return addressList;
    }

}