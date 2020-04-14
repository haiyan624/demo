package com.wq.rabbit.work;

import com.rabbitmq.client.*;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    private static final String QUEUE_NAME = "work_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 同一时刻只发一条消息
        channel.basicQos(1);
        for (int i = 0; i < 10; i++) {
            String msg = "work msg " + i;
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        }
        channel.close();
        connection.close();
    }

}
