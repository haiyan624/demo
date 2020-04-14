package com.wq.rabbit.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 5672;
    private static final String V_HOST = "/test";
    private static final String USER_NAME = "remote_none";
    private static final String PASSWORD = "remote_none";

    /**
     * 建立与RabbitMQ的连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost(HOST);
        //端口
        factory.setPort(PORT);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost(V_HOST);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        // 通过工厂获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
