package com.hou.rabbitmq.controller;

import com.rabbitmq.client.*;
/**
 * 使用RabbitMQ原生API
 */
public class TestAPI {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("192.168.171.128");
        factory.setPort(5672);
        factory.setPassword("admin");
        factory.setUsername("admin");
        factory.setConnectionTimeout(600000);
        Connection connection = factory.newConnection();//创建连接
        Channel channel = connection.createChannel();//创建管道
        //创建一个名字为exchange,direct类型,消息持久化,非自动删除的交换器
        channel.exchangeDeclare("exchange", "direct", true, false, null);
        //创建队列,持久化,非排他,非自动删除的消息队列
        channel.queueDeclare("queue",true,false,false,null);
        //绑定队列与交换器,用key
        channel.queueBind("queue","exchange","key_test");
        //发送消息
        String message="test";
        //指定交换器名称,绑定key,消息类型即可,会自动找到绑定的队列,
        channel.basicPublish("exchange","key_test",MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
        channel.close();
        connection.close();
    }
}
