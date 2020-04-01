package com.hou.goodspurchase;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(basePackages = "com.hou.goodspurchase.dao",annotationClass = Mapper.class ) //指定mybatis接口扫描类

public class GoodsPurchaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsPurchaseApplication.class, args);
    }
}
