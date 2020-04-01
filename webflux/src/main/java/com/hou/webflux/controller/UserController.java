package com.hou.webflux.controller;


import com.hou.webflux.pojo.User;
import com.hou.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("user/{id}")
    public Mono<User> getUser(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }
    @PostMapping("/user")
    public Mono<User> inserUser(@RequestBody User user){
        return userService.insertUser(user);
    }
    @PutMapping("/user")
    public Mono<User> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("user/{id}")
    public Mono<Void> deleteById(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }
    @GetMapping("/user/name")
    public Flux<User> findUserByUserName(String userName){
        return userService.findUsers(userName);
    }

    //接受自定义转换参数
    @PostMapping("/user/str")
    public Mono<User> inserUserByString(@RequestBody User user){
        return userService.insertUser(user);
    }

}
