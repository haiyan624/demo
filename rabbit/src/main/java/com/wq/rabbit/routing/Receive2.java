package com.wq.rabbit.routing;

import com.rabbitmq.client.*;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive2 {

    private static final String EXCHANGE_NAME = "routing_exchange_name";

    private static final String QUEUE_NAME = "routing_queue_name2";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicQos(1);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "error");

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("[rev2 msg]:" + msg);
                channel.basicAck(envelope.getDeliveryTag(), false);
                System.out.println("[rev2 down] ");
            }
        };
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}