package com.wq.rabbit.simple;

import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class Send {

    private static final String QUEUE_NAME = "simple_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        for (int i=10;i>0;i--){
        String msg = "simple msg " + new Date();
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        System.out.println("[simple send success:]" + msg);
//        }
        channel.close();
        connection.close();
    }
}
