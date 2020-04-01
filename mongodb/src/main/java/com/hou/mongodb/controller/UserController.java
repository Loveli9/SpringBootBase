package com.hou.mongodb.controller;

import com.hou.mongodb.pojo.User;
import com.hou.mongodb.service.UserService;
import com.mongodb.bulk.DeleteRequest;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //添加用户
    @RequestMapping("/insert")
    public String insertUser(@RequestBody User user){
        userService.insertUser(user);
        return "";
    }

    //根据id获取用户
    @RequestMapping("select/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    //根据条件查询符合条件的用户
    @RequestMapping("/find")
    public List<User> getUsers(String userName,Integer skip,Integer limit){
        return userService.getUsers(userName,skip,limit);
    }

    //更新用户
    @RequestMapping("/update")
    public UpdateResult updateUser(Integer id, String userName){
        return userService.updateUser(id,userName);
    }

    //删除用户
    @RequestMapping("/delete")
    public DeleteResult deleteUser(Integer id){
        return userService.deleteUser(id);
    }

}
