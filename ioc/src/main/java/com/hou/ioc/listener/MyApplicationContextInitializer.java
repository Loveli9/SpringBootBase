package com.hou.ioc.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * ApplicationContextInitializer接口是Spring容器执行refreshed方法之前的回调
 * 使用步骤:1 写个类实现此接口
 * 2 注册ApplicationContextInitializer实现类
 * 注册方法: 1 SpringApplication.addInitializers
 * 2 通过配置文件 context.intitializer.classes=类名指定,可指定多个,用,隔开
 * 3 通过spring.factories机制
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("===============");
    }
}
