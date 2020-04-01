package com.hou.rabbitmq.controller;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class TestReceiverAPI {
    public static void main(String[] args) throws Exception {
        Address[] addresses=new Address[]{
                new Address("192.168.171.128",5672)};
        ConnectionFactory factory=new ConnectionFactory();
        factory.setPassword("admin");
        factory.setUsername("admin");
        factory.setConnectionTimeout(600000);
        Connection connection = factory.newConnection(addresses);//创建连接
        Channel channel = connection.createChannel();//创建管道
        channel.basicQos(64);//设置客户端最多接受未确认的消息个数
        //接受消息
        Consumer consumer = new DefaultConsumer(channel) {
            //接受到消息时回调
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println("接受到消息:"+new String(body));
                //消息消费成功回调
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume("queue",consumer);//消费消息
        //等待回调函数执行完毕,再关闭ziy8uan
        TimeUnit.SECONDS.sleep(3);
        channel.close();
        connection.close();
    }
}
