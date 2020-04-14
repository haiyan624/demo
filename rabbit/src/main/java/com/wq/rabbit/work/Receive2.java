package com.wq.rabbit.work;

import com.rabbitmq.client.*;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive2 {
    private static final String QUEUE_NAME = "work_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String msg = new String(body);
                System.out.println("receive work queue msg:" + msg);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
