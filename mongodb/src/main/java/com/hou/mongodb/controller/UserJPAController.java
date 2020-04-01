package com.hou.mongodb.controller;

import com.hou.mongodb.pojo.User;
import com.hou.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class UserJPAController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        Optional<User> byId = userRepository.findById(id);
        return byId.orElse(new User(-1,"查询不到该用户"));
    }
}
