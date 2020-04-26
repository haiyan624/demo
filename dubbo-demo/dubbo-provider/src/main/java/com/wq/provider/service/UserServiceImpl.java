package com.wq.provider.service;

import com.wq.dinterface.entity.UserAddress;
import com.wq.dinterface.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1 = new UserAddress(1, "山东省青岛市", "1", "张三", "6666", "Y");
        UserAddress address2 = new UserAddress(2, "四川省成都市", "1", "李四", "8888", "N");
//        if (Math.random() > 0.5) {
//            throw new RuntimeException();
//        }
        return Arrays.asList(address1, address2);
    }

}