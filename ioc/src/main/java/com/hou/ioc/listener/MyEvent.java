package com.hou.ioc.listener;

import org.springframework.context.ApplicationEvent;

/**
 * 定义事件
 */
public class MyEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    //构造器
    public MyEvent(Object source) {
        super(source);
    }

}
