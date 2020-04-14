package com.wq.rabbit.work2;

import com.rabbitmq.client.*;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    public static final String QUEUE_NAME = "work2_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        for (int i = 0; i < 50; i++) {
            String msg = "work 2 msg " + i;
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            System.out.println("publish msg :" + msg);
        }
        channel.close();
        connection.close();
    }
}
