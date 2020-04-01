package com.hou.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//EnableMongoRepositories 扫描继承了MongoRepositories的接口
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.hou.mongodb.repository")
public class MongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }
}
