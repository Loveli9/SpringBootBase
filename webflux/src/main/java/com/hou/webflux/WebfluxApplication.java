package com.hou.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * 引入JPA默认会自动配置关系型数据源,所以要排除自动配置
 */
@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class}) //排除自动数据源配置
@EnableReactiveMongoRepositories(basePackages = "com.hou.webflux.repository") //扫描JPA接口
public class WebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }
}
