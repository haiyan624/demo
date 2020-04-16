package com.wq.rabbit.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send1 {

    private static final String QUEUE_NAME = "simple_confirm_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.confirmSelect();

        String msg = "simple confirm msg";

        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        if(channel.waitForConfirms()){
            System.out.println("send msg success");
        } else{
            System.out.println("send msg failed");
        }

        channel.close();
        connection.close();
    }
}
