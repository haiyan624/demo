package com.wq.rabbit.topic;

import com.rabbitmq.client.*;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive1 {

    private static final String EXCHANGE_NAME = "topic_exchange_name";
    private static final String QUEUE_NAME = "topic_queue_name1";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtil.getConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "good.*");
        channel.basicQos(1);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("[rev1] msg:" + msg);
                channel.basicAck(envelope.getDeliveryTag(), false);
                System.out.println("[msg done:]" + msg);
            }
        };
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
