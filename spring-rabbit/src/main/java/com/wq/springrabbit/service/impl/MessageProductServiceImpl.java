package com.wq.springrabbit.service.impl;

import com.wq.springrabbit.configure.MyConfigure;
import com.wq.springrabbit.service.IMessageProductService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProductServiceImpl implements IMessageProductService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String msg) {
        rabbitTemplate.convertAndSend(MyConfigure.EXCHANGE_NAME, MyConfigure.ROUTING_KEY, msg);
    }
}
