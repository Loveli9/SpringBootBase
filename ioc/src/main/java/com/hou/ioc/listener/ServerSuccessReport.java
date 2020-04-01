package com.hou.ioc.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner接口:是容器启动后的最后一步回调
 * 使用步骤: 1 写个类,实现此接口
 * 2 把该类加入Spring中
 * 注意:可以用@Order注解或者Ordered接口来控制多个实现类的执行顺序
 * ApplicationRunner接口与CommandLineRunner接口作用一样:
 * 区别:CommandLineRunner的参数是最原始的
 * 而ApplicationRunner的参数是ApplicationArguments,是对原始参数的封装
 * ApplicationArguments是对参数(main方法)做进一步处理
 * 可以解析--name=value的,可以通过name获取value:
 */
@Order(2)   //调整顺序,越大越往后执行
@Component
public class ServerSuccessReport implements CommandLineRunner {
    public void run(String... args) throws Exception {
        System.out.println("应用成功启动===========");
    }
}
