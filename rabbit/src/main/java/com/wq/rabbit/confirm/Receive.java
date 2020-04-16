package com.wq.rabbit.confirm;

import com.rabbitmq.client.*;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class Receive {

//    private static final String QUEUE_NAME = "simple_confirm_queue_name";
    private static final String QUEUE_NAME = "simple_confirm_aync_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                String msg = new String(body);
                System.out.println("[confirm receive ]" + msg);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
