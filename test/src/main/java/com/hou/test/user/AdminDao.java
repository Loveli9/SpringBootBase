package com.hou.test.user;

import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

    //添加方法
    public Integer addUser(String userName) {
        System.out.println("username=" + userName);
        return userName == null ? 0 : 1;
    }

}
