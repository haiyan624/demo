package com.wq.rabbit.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    private static final String EXCHANGE_NAME = "topic_exchange_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String msg1 = "good add msg";
        String msg2 = "good del msg";
        String msg3 = "user action add";
        channel.basicPublish(EXCHANGE_NAME, "good.add", null, msg1.getBytes());
        channel.basicPublish(EXCHANGE_NAME, "good.del", null, msg2.getBytes());
        channel.basicPublish(EXCHANGE_NAME, "user.add", null, msg3.getBytes());

        channel.close();
        connection.close();
    }
}
