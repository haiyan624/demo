package com.wq.rabbit.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * channel.exchangeDeclare(EXCHANGE_NAME, "direct");
 */
public class Send {

    private static final String EXCHANGE_NAME = "routing_exchange_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 四种Exchanges类型：direct 交换机, topic, headers and fanout 发布/订阅
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String msg1 = "routing msg type info";
        String msg2 = "routing msg type error";
        channel.basicPublish(EXCHANGE_NAME, "info", null, msg1.getBytes());
        channel.basicPublish(EXCHANGE_NAME, "error", null, msg2.getBytes());

        channel.close();
        connection.close();
    }
}
