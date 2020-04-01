package com.hou.ioc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@PropertySource("file:/E:/app/app.yml")  //指定文件系统,可指定多个
//也可以用下面这个注解指定多个
//@PropertySources({@PropertySource("file:/E:/app/app.yml"),@PropertySource("classpath:db.yml")})
@Configuration     //表示此类为 配置文件类,相当于配置文件
@PropertySource("classpath:db.yml")   //指定配置文件位置
@ConfigurationProperties("database")
public class DBConfig {
    /**
     * 使用@value注入,也可使用set方法注入,
     * 但是set方法名称必须与配置文件中database.后面的一致,否则获取不到
     */
    @Value("${url}")
    private String url;
    @Value("${userName}")
    private String userName;
    @Value("${passWord}")
    private String passWord;
    @Value("${driveClass}")
    private String driveClass;

    @Override
    public String toString() {
        return "DBConfig{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", driveClass='" + driveClass + '\'' +
                '}';
    }
}
