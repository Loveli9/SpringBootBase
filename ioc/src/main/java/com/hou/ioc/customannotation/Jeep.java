package com.hou.ioc.customannotation;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync   //启用异步特性,启用后有@Async注解的方法会异步执行,否则有Async注解也会同步
public class Jeep {

    @Async    //异步方法
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("==========" + i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
