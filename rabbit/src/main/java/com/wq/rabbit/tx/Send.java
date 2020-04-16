package com.wq.rabbit.tx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.TimeoutException;

public class Send {

    private static final String QUEUE_NAME = "tx_simple_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String msg = "tx test";
        try {
            channel.txSelect();
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            int aa = 1 / 0;
            channel.txCommit();
        } catch (Exception e) {
            channel.txRollback();
            System.out.println("tx rollback");
        } finally {
            System.out.println("tx send over");
            channel.close();
            connection.close();
        }
    }
}
