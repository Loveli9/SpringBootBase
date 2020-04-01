package com.hou.ioc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

//必须实现 EnvironmentPostProcessor接口,且必须在META-INF目录下的spring.factories文件中注册
@Component
public class UnfiedConfig implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            //读取硬盘或者远程的统一配置文件
            InputStream is = new FileInputStream("E:/henghua.properties");
            Properties source = new Properties();
            source.load(is);//资源文件加载读取到的信息
            //参数:  名称, 资源文件
            PropertiesPropertySource propertiesSource = new PropertiesPropertySource("MyConfig", source);
            //环境中加载配置文件,可以从环境中读取此配置文件信息
            environment.getPropertySources().addLast(propertiesSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
