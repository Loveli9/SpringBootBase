package com.hou.security.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async   //使用异步执行
    public void createReport() {
        System.out.println("执行报表方法线程:"+Thread.currentThread().getName());
    }
}
