package com.hou.groovy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@MapperScan(basePackages = "com.hou.groovy.dao",annotationClass = Repository.class ) //指定mybatis接口扫描类
@SpringBootApplication
public class GroovyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroovyApplication.class, args);
    }

}
