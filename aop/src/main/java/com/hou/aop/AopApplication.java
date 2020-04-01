package com.hou.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);
        //调用业务方法
        User user = new User();
        user.setName("侯征");
        context.getBean(UserDao.class).addUser(user);
        context.getBean(UserDao.class).selectUser();
        context.close();
    }
}
