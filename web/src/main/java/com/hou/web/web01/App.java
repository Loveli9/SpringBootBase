package com.hou.web.web01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * springboot中使用servlet
 * 方法一:(servlet3可以使用这种方法)
 * 1.编写servlet,然后加上相应注解
 * 2.需要启用@ServletComponentScan注解
 * 方法二:(servlet2.5以及以下可以使用这种)
 * 1.编写servlet
 * 2.装配相应的bean到Spring容器中
 * servlet:ServletRegistrationBean
 * filter: FilterRegistrationBean
 * listener: ServletListenerRegistrationBean
 */
@ServletComponentScan  //启用servlet
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //启动
        SpringApplication.run(App.class, args);
    }

}
