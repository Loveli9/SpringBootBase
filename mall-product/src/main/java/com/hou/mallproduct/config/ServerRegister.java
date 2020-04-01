package com.hou.mallproduct.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceInstanceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * 项目启动时服务注册到zookeeper中
 * ApplicationRunner: 容器启动后的回调,可以做一些初始化操作
 */
@Component
public class ServerRegister implements ApplicationRunner {
    @Value("${zookeeper.address}")
    private String zkAddr;//注入zk地址

    public void run(ApplicationArguments args) throws Exception {
        //curator操作zk
        CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddr, new RetryOneTime(10000));
        client.start();
        client.blockUntilConnected();
        //构建要注册的服务
        ServiceInstance<Object> instance = ServiceInstance.builder()
                .address("192.168.1.103").port(8080)
                .name("tomcat").build();//name为必须
        //使用服务发现对象注册
        ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class)
                                .client(client)       //curator实例
                                .basePath("/mall")   //注册的节点
                                .build();
        serviceDiscovery.registerService(instance);//注册的服务
        serviceDiscovery.start();//开启注册
        System.out.println("-------服务注册成功---------");
    }
}
