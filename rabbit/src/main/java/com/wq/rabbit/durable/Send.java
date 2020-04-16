package com.wq.rabbit.durable;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.BasicProperties.Builder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
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
        Builder builder = new Builder();
        builder.deliveryMode(2);
        BasicProperties properties = builder.build();
        for (int i = 0; i < 10; i++) {
            String msg = "work msg " + i;
            channel.basicPublish("", QUEUE_NAME, properties, msg.getBytes());
        }
        channel.close();
        connection.close();
    }

}
