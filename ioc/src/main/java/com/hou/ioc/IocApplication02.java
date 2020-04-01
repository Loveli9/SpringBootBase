package com.hou.ioc;

import com.hou.ioc.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.HashSet;
import java.util.Set;

//加载配置文件
@SpringBootApplication
public class IocApplication02 {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(IocApplication02.class, args);
        //不指定会加载默认的配置文件
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String port = environment.getProperty("server.port");//获取配置文件中的属性
        System.out.println(port);
        applicationContext.close();
    }
}
