package com.wq.springrabbit.service;

import com.wq.springrabbit.configure.MyConfigure;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    @RabbitListener(queues = MyConfigure.QUEUE_NAME)
    public void receiveMessage(String msg){
        System.out.println("接收消息：" + msg);
    }
}
