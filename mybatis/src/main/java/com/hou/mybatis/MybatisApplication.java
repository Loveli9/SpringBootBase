package com.hou.mybatis;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import java.util.Properties;

@SpringBootApplication
@MapperScan(basePackages = "com.hou.mybatis.dao",annotationClass =Repository.class ) //指定mybatis接口扫描类
@EnableAspectJAutoProxy(exposeProxy = true) //表示通过aop框架暴露该代理对象，aopContext能够访问,获取代理对象
@EnableCaching  //开启缓存
public class MybatisApplication {

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");   //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
     }


    //配置Mybatis接口扫描
   /* @Bean
    public MapperScannerConfigurer mapperScannerConfigurerConfig(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //springboot会自动注入sqlSessionFactory实例
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //定义扫描包
        mapperScannerConfigurer.setBasePackage("com.hou.mybatis.dao.*");
        //限定加入@Repository注解才扫描,防止扫描错误
        mapperScannerConfigurer.setAnnotationClass(Repository.class);
        return mapperScannerConfigurer;
    }*/


    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
