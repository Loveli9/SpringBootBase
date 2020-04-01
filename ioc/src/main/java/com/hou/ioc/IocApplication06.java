package com.hou.ioc;

import com.hou.ioc.customannotation.Enableprint;
import com.hou.ioc.customannotation.TomcatProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan   //单独使用无法获取,还需要使用@EnableAutoConfiguration一起才能获取
//@SpringBootApplication  //单独使用可以获取
@Enableprint(packages = {"cn.hou.springboot02", "cn.hou.springboot03"}) //使用自定义注解,实现功能
public class IocApplication06 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IocApplication06.class, args);
        System.out.println(context.getBean(TomcatProperties.class));
        context.getBean(Runnable.class).run();
        System.out.println("-------end");
        context.close();
    }

}
