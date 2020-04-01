package com.hou.ioc.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootConfiguration   //标注此类为配置类
public class MyConfig {

    /*@Bean   //装配Bean,默认装配
    public Runnable getRunable(){
        return ()->{
            System.out.println("hello springBoot");
        };
    }*/

    @Bean
    @Profile("test") //@Profiel 指定配置文件,只有当SpringApplicaiton加载了指定的test配置文件,才会创建这个Bean
    public Runnable getTestRunnable() {
        System.out.println("===============test============");
        return () -> {
        };
    }

    @Bean
    @Profile("dev") //同上
    public Runnable getDevRunnable() {
        System.out.println("===============dev===========");
        return () -> {
        };
    }
}
