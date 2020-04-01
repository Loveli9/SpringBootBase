package com.hou.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列Bean配置
 */
@Configuration
public class MessageQueueConfig {

    @Value("${rabbit.queue.string}")
    private String strQueueName;

    @Value("${rabbit.queue.object}")
    private String objQueueName;

    //配置Queue
    @Bean
    public Queue createStringQueue() {
        //boolean表示消息是否持久化
        return new Queue(strQueueName, true);
    }
    @Bean
    public Queue createObjectQueue(){
        //boolean表示消息是否持久化
        return new Queue(objQueueName,true);
    }
}
