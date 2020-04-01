package com.hou.rabbitmq.controller;

import com.hou.rabbitmq.pojo.User;
import com.hou.rabbitmq.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class TestController {

    @Autowired
    private MessageSendService mseeageSendService;

    @RequestMapping("/str")
    public void sendString(){
        mseeageSendService.sendString("hello rabbitmq");
    }

    @RequestMapping("/obj")
    public void sendObject(){
        User user=new User();
        user.setId("001");
        user.setName("消息对象");
        mseeageSendService.sendObject(user);
    }
}
