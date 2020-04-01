package com.hou.rabbitmq.receiver;

import com.hou.rabbitmq.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接受
 */
@Component
public class MessageReceiver {

    @RabbitListener(queues = {"${rabbit.queue.string}"})
    public void receiverString(String message){
        System.out.println("接受到字符串消息:"+message);
    }

    @RabbitListener(queues = {"${rabbit.queue.object}"})
    public void receiverObject(User user){
        System.out.println("接受到对象消息:"+user.toString());
    }
}

