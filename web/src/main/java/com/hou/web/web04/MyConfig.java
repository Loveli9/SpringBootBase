package com.hou.web.web04;

import org.apache.catalina.valves.AccessLogValve;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootConfiguration
public class MyConfig {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8081);
                //指定错误跳转
                factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
            }
        };
    }

    //@Bean
   /* public EmbeddedServletContainerFactory get() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8181);//指定端口
        //指定错误跳转
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        //添加初始化操作
        factory.addInitializers((servletContext) -> {
            System.out.println("------------tomcat 启动----------");
            servletContext.setAttribute("start", "tomcat启动");
            //添加过滤器,监听器等
            //servletContext.addFilter(filterName, className)
        });
        //添加日志
        factory.addContextValves(getAccessLogValve());
        return factory;
    }*/

    /*//获取日志
    public AccessLogValve getAccessLogValve() {
        AccessLogValve log = new AccessLogValve();
        //启用日志
        log.setEnabled(true);
        //设置日志模板格式,日志非实时写入,需要等待
        log.setPattern("%n %l %u %t \"%r\" %s %b");
        //log.setDirectory("e:/tmp/logs");//自定义日志目录
        //设置日志文件前缀
        log.setPrefix("springboot-log");
        //设置后缀
        log.setSuffix(".txt");
        return log;
    }*/
}
