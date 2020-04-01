package com.hou.ioc.listener;

import org.springframework.context.ApplicationListener;

/**
 * 定义MyEvent事件的监听器
 */
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("监听到事件:" + event.getClass().getName());
    }

}
