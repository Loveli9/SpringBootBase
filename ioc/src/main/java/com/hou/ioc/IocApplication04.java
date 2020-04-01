package com.hou.ioc;

import com.hou.ioc.config.DBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class IocApplication04 {

    public static void main(String[] args) {
        //创建配置对象
        SpringApplication springApplication = new SpringApplication(IocApplication04.class);
        //指定读取的配置文件,不指定会加载默认的配置文件,application.properties
        //springApplication.setAdditionalProfiles("test");//测试环境 //8082
        springApplication.setAdditionalProfiles("dev");//开发环境 //8081
        //不指定加载默认的,8080
        //启动容器
        ConfigurableApplicationContext context = springApplication.run(args);
        //获取对应的配置文件值
        System.out.println("服务器端口：" + context.getEnvironment().getProperty("server.port"));
        Runnable runnable = (Runnable) context.getBean(Runnable.class);
        runnable.run();
        context.close();
    }
}
