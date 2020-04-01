package com.hou.aop;

import org.springframework.stereotype.Component;

@Component
public class UserDao {


    public void addUser(User user) {
        System.out.println("-----添加用户------");
    }
    
    public void selectUser() {
        System.out.println("-----查询用户------");
    }

}
