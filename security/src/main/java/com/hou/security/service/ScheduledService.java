package com.hou.security.service;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

public interface ScheduledService {

    @Scheduled(fixedRate = 1000)  //每隔一秒钟执行一次
    default void job01(){
        System.out.println("job01执行"+new Date());
    };
    //容器启动后30秒之后开始执行,每个隔两秒执行
    @Scheduled(initialDelay = 30000,fixedRate = 2000)
    default void job02(){
        System.out.println("job2开始执行"+new Date());
    };
    //每年每月每天的16点每分钟0秒开始执行,即 16-17点之间,每分钟执行
    @Scheduled(cron = "0 * 16 * * ?")
    default void job03(){
        System.out.println("job3执行:"+new Date());
    };
}
