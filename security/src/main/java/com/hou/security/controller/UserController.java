package com.hou.security.controller;

import com.hou.security.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Stream;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/test")
    public String testController(){
        return "hello world";
    }

    @GetMapping("/admin")
    public String adminController(){
        return "hello admin";
    }

    @GetMapping("/other")
    public String otherController(){
        System.out.println("请求controller线程:"+Thread.currentThread().getName());
        asyncService.createReport();
        return "hello other";
    }

    //需要ROLE_USER才行,不用在配置类配置路径,直接方法加注解即可实现权限拦截
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")  //方法前验证,支持EL表达式
    @GetMapping("/anno")
    public String annoTest(){
        return "注解权限验证成功";
    }
}
