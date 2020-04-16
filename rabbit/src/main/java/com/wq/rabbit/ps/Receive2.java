package com.wq.rabbit.ps;

import com.rabbitmq.client.*;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive2 {

    private static final String EXCHANGE_NAME = "publish_subscribe_exchange_name";

    private static final String QUEUE_NAME = "public_subscribe_queue_name2";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtil.getConnection();
        final Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        channel.queueDeclare(QUEUE_NAME,false, false,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("[queue2 rev msg]:" + msg);
                channel.basicAck(envelope.getDeliveryTag(),false);
                System.out.println("[queue2 done:]"+msg);
            }
        };

        channel.basicConsume(QUEUE_NAME,false,consumer);

    }
}
