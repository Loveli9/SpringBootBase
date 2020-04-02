package com.hou.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class TestController {
    private static Logger log = LoggerFactory.getLogger(TestController.class);
    @GetMapping("/01")
    public String test01(){
        return "test";
    }
    @GetMapping("/02")
    public String test02(){
        return "test";
    }


    //死锁测试
    @GetMapping("/dead")
    public void deadLock(String name) throws InterruptedException {
       System.out.println("---name---"+name);
        new Thread(() -> {
            synchronized ("死锁"){
                while(true){
                }
            }
        },"houzheng01").start();
        new Thread(() -> {
            synchronized ("死锁"){
                System.out.println("------");
           }
        },"houzheng02").start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("end");
    }

    //死锁测试
    @GetMapping("/num")
    public void num01() throws InterruptedException {
        num();//被调用两次
        num();
        TimeUnit.SECONDS.sleep(2);
    }

    public void num(){
        System.out.println("-----");
    }


    public static void main(String[] args) {

    }
}
