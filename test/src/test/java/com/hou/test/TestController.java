package com.hou.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

/**
 * TestRestTemplate需要运行在web环境中
 * webEnvironment:web服务,用于测试需要web环境的类,提供一个测试web服务,,还需要再
 *  SpringBootTest注解加上 启动类class
 */
@SpringBootTest(classes= TestApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TestController {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testUserController() {
        //根据url,获取返回的内容
        String response = restTemplate.getForObject("/user/name", String.class);
        Assert.assertEquals("yaozhen", response);
    }

    @Test
    public void testUserController01() {
        //根据url,获取返回的内容 ,访问内嵌的web服务直接运行
        String response = restTemplate.getForObject("/user/age?age=24", String.class);
        Assert.assertEquals("24", response);
    }

}
