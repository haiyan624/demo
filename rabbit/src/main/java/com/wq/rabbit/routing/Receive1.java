package com.wq.rabbit.routing;

import com.rabbitmq.client.*;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "error");
 */
public class Receive1 {

    private static final String EXCHANGE_NAME = "routing_exchange_name";

    private static final String QUEUE_NAME = "routing_queue_name1";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicQos(1);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "error");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "waring");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "info");

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("[rev1 msg]:"+msg);
                channel.basicAck(envelope.getDeliveryTag(),false);
                System.out.println("[rev1 down] ");
            }
        };
        channel.basicConsume(QUEUE_NAME,false,consumer);
    }
}