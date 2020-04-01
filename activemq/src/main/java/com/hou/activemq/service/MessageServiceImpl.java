package com.hou.activemq.service;

import com.hou.activemq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private JmsTemplate jmsTemplate;

    private final String DESTINATION_USER="user";

    @Override
    public void sendMessage(String message) {
        //发送消息,不指定队列,发送到默认队列
        jmsTemplate.convertAndSend(message);
    }
    //spring4.1版本之后可以使用此注解简化开发@JmsListener
    @Override  //监听默认的消息队列
    @JmsListener(destination = "activemq")
    public void receiveMessage(String message) {
        System.out.println("接收到消息:"+message);
    }

    @Override  //发送到指定队列
    public void sendUser(User user) {
        jmsTemplate.convertAndSend(DESTINATION_USER,user);
    }

    @Override
    @JmsListener(destination =DESTINATION_USER)
    public void receiveUser(User user) {
        System.out.println("接受到用户消息:"+user);
    }
}
