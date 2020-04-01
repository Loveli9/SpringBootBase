package com.hou.ioc.customannotation;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @EnableAutoConfiguration:用来启用一个特性:即把配置文件中的属性自动注入到Bean中
 * 如果不使用此注解, 则无法获取配置文件值, 比如作用于配置类上时@ComponentScan没有实现这个注解,无法获取
 * 但是@SpringBootApplication实现了这个注解,就可以获取到
 */
@Component
@ConfigurationProperties(prefix = "tomcat")
public class TomcatProperties {

    private String ip;

    private String port;

    @Override
    public String toString() {
        return "TomcatProperties [ip=" + ip + ", port=" + port + "]";
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }


}
