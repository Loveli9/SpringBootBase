package com.hou.web.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Springboot处理静态资源:
 * 1.src/main/webapp目录下,可以直接访问
 * 2.默认路径下可以直接访问:classpath:/META-INF/resources,
 * classpath:/resources/,classpath:/static/,classpath:/public/
 * 3.配置文件修改默认路径: 比如:spring.resources.staticLocations=classpath:/html
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //启动
        SpringApplication.run(App.class, args);
    }

}
