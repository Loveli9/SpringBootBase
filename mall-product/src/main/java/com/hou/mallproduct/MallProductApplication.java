package com.hou.mallproduct;

import com.hou.mallproduct.mapper.ProductMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 服务启动的时候:将服务信息(ip:port)注册到zookeeper上
 */
@SpringBootApplication
public class MallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }
}
