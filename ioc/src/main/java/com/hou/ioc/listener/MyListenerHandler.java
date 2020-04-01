package com.hou.ioc.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 此类必须加入容器中
 */
@Component
public class MyListenerHandler {
    /**
     * 参数必须是Application或者其子类,比如MyListener
     * Object就表示监听所有application类和其子类
     *
     * @EventListener此方法会自动监听参数中的事件
     */
    @EventListener
    public void event(MyEvent event) {
        System.out.println("MyListener接受事件" + event.getClass().getName());
    }

}
