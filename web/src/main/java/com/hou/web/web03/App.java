package com.hou.web.web03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 拦截器的使用:
 * 1.写一个拦截器,实现HandlerInterceptor接口
 * 2.写一个类,继承WebMvcConfigurerAdapter抽象类,重写addInterceptor方法
 * 并调用register.addInterceptor方法把拦截器加入
 * HandlerInterceptor接口的三个方法:
 * preHandler   :Controller执行之前调用
 * postHandler  :Controller执行之后,页面渲染之前调用
 * afterHandler :页面渲染之后调用,一般用于资源清理操作
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //启动
        SpringApplication.run(App.class, args);
    }

}
