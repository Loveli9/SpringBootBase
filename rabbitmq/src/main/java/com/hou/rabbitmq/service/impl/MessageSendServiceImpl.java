package com.hou.rabbitmq.service.impl;

import com.hou.rabbitmq.pojo.User;
import com.hou.rabbitmq.service.MessageSendService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 消息接受成功回调需要实现ConfirmCallback接口
 */
@Service
public class MessageSendServiceImpl implements RabbitTemplate.ConfirmCallback,MessageSendService {
    @Value("${rabbit.queue.string}")
    private String strQueueName;

    @Value("${rabbit.queue.object}")
    private String objQueueName;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    public void sendString(String message) {
        //设置回调接口
        rabbitTemplate.setConfirmCallback(this);
        //发送消息到指定队列
        rabbitTemplate.convertAndSend(strQueueName,message);
    }
    @Override
    public void sendObject(User user) {
        //设置回调接口
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(objQueueName,user);
    }
    //回调确认方法
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if(b){
            System.out.println("消息发送成功");
        }else{
            System.out.println("消息消费失败:"+s);
        }
    }
}
