package com.wq.rabbit.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.wq.rabbit.util.ConnectionUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

public class Send3 {
    private static final String QUEUE_NAME = "simple_confirm_aync_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.confirmSelect();

        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());

        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                if(multiple){
                    System.out.println("--handle ack--multiple--true-");
                    confirmSet.headSet(deliveryTag+1).clear();
                } else{
                    System.out.println("---handle ack----multiple---false---");
                    confirmSet.remove(deliveryTag);
                }
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                if(multiple){
                    System.out.println("----handle ack----multiple-----true");
                    confirmSet.headSet(deliveryTag+1).clear();
                } else {
                    System.out.println("-------handle ack-----multiple----false");
                    confirmSet.remove(deliveryTag);
                }
            }
        });

        String msg = "aync msg";
        int i=0;
        while (true){
            long seqNo = channel.getNextPublishSeqNo();
            channel.basicPublish("",QUEUE_NAME,null,(msg+i).getBytes());
            confirmSet.add(seqNo);
            if(i%10==0){
                Thread.sleep(1000);
            }
            i++;
        }
    }
}
