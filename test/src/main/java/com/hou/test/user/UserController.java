package com.hou.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private AdminDao adminDao;

    @GetMapping("/name")
    public String getName() {
        System.out.println("Controller is on");
        adminDao.addUser("haha");
        return "yaozhen";
    }

    @GetMapping("/age")
    public String getAge(@RequestParam("age") String age) {
        System.out.println("Controller is on");
        return age;
    }

}
