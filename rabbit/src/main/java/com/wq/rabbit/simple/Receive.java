package com.wq.rabbit.simple;

import com.rabbitmq.client.*;
import com.wq.rabbit.util.ConnectionUtil;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 测试了下，先发送了十个消息，控制台显示有十个消息
 * 等到receive启动后控制台显示剩余0个
 * 说明自动ack情况下，会将消息一下子发出去。
 *
 */
public class Receive {

    private static final String QUEUE_NAME = "simple_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false, false,false,null);

        DefaultConsumer consumer = new DefaultConsumer(channel){
            @SneakyThrows
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body){
                String msg = new String (body);
                System.out.println("simple new receive ]" + msg);
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }

    public static void oldFunction() throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false, false,false,null);
        QueueingConsumer consumer = new QueueingConsumer (channel);
        channel.basicConsume(QUEUE_NAME,true,consumer);
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println("[simple old receive ]" + msg);

        }
    }
}
