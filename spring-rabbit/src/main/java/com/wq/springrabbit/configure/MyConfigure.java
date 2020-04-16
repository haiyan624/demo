package com.wq.springrabbit.configure;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigure {

    public static final String QUEUE_NAME="spring_rabbit_queue_name";

    public static final String EXCHANGE_NAME = "spring_rabbit_exchange_name";

    public static final String ROUTING_NAME = "spring_rabbit_routing_name";;

    @Bean
    public Queue createQueue(){
        return new Queue(QUEUE_NAME);
    }

    
}
