package com.hou.activemq;

import com.hou.activemq.pojo.User;
import com.hou.activemq.service.MessageService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@EnableJms
public class ActivemqApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(ActivemqApplication.class, args);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MessageService messageService = applicationContext.getBean(MessageService.class);
        messageService.sendMessage("测试消息");
        User user = new User();
        user.setName("侯征");
        user.setId(1);
        messageService.sendUser(user);
    }
}
