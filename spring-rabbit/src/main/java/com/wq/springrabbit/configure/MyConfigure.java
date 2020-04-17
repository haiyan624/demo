package com.wq.springrabbit.configure;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfigure {

    public static final String QUEUE_NAME = "spring_rabbit_queue_name";

    public static final String EXCHANGE_NAME = "spring_rabbit_exchange_name";

    public static final String ROUTING_KEY = "spring_rabbit_routing_name";
    ;

    @Bean
    public Queue createQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public DirectExchange getDirectExchange() {
        //DirectExchange(String name, boolean durable, boolean autoDelete)
        return new DirectExchange(EXCHANGE_NAME, true, true);
        //TopicExchange
        //FanoutExchange
        //HeadersExchange
    }

    /**
     * 交换机和路由键绑定
     *
     * @param exchange
     * @param queue
     * @return
     */
    @Bean
    public Binding binding(DirectExchange exchange, Queue queue) {

        int aa = 0;
        List<String> list = new ArrayList<>();
        int n=100;
        for (int i = 0; i < 100; i++) {
            for (int b = 0; b < 100; b++) {
                for (int c = 0; c < 100; c++) {
                    aa=i+b+c;
                    list.add("test");
                }
            }
        }

        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
