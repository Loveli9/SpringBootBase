package com.hou.ioc;

import com.hou.ioc.listener.MyEvent;
import com.hou.ioc.listener.MyListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class IocApplication08 {

    public static void main(String[] args) {
        //创建配置类对象
        SpringApplication application = new SpringApplication(IocApplication08.class);
        //添加监听器
        application.addListeners(new MyListener());
        //启动容器
        ConfigurableApplicationContext context = application.run(args);
        //发布事件
        context.publishEvent(new MyEvent(new Object()));
        context.close();
    }
}
