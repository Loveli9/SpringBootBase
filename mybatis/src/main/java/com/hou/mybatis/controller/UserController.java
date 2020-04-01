package com.hou.mybatis.controller;

import com.github.pagehelper.PageInfo;
import com.hou.mybatis.domain.PO.User;
import com.hou.mybatis.domain.VO.PageBean;
import com.hou.mybatis.service.UserBatchService;
import com.hou.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService userService;
    @Autowired private UserBatchService userBatchService;

    @GetMapping("/findAll")
    public PageInfo findAllUserByPage(int currentPage, int pageSize){
        log.debug("查询所有用户");
        return userService.findAllUserByPage(currentPage,pageSize);
    }

    @GetMapping("/getUser")
    public User selectUser(String id){
        return userService.selectUserById(id);
    }

    @GetMapping("/deleteUser")
    public int deleteUser(String id){
        return userService.deleteUserById(id);
    }

    @GetMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping("/insert")
    public User insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @PostMapping("/insertBatch")
    public Integer insertBatchUser(@RequestBody List<User> userList){
        return userBatchService.insertBatchUser(userList);
    }

    @GetMapping("/insertTest")
    public String insertTest10000(){
        for (int i = 0; i < 10000; i++) {
            User user =new User();
            user.setName("test"+i);
            user.setAge(i);
            userService.insertUser(user);
        }
        return "ok";
    }
}

