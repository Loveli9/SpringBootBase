package com.hou.web.web04;

import java.io.File;
import java.net.InetAddress;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


/**
 * WebServerFactoryCustomizer:
 * 定制tomcat
 */
@Component
public class MyEmbeddedServerContainerCustomizer implements WebServerFactoryCustomizer {

    public void customize(WebServerFactory factory) {
        //强转为tomcat容器工厂.对tomcat属性进行定制
        //指定端口
        ConfigurableWebServerFactory factory1 = (ConfigurableWebServerFactory) factory;
        factory1.setPort(8081);
        //指定错误跳转
        factory1.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
    }
}

