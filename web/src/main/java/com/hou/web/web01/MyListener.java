package com.hou.web.web01;

import java.time.LocalDate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    public MyListener() {
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    }

    /**
     * 监听应用启动
     */
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("应用启动:" + LocalDate.now().toString());
    }

}
