package com.hou.ioc;

import com.hou.ioc.condition.EncodingConvert;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IocApplication05 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IocApplication05.class, args);
        //打印java文件编码格式
        System.out.println("java文件编码格式-------" + System.getProperty("file.encoding"));
        //根据接口类型取出所有实现类的Bean
        System.out.println(context.getBeansOfType(EncodingConvert.class));
        System.out.println(context.getBeansOfType(Runnable.class));
        context.close();
    }

}
