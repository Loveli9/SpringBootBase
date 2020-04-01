package com.hou.groovy.controller

import com.hou.groovy.bean.PO.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {

    @GetMapping("/test")
    List<String> testMethod(){
        def list=[]
        //groovy中 "" 默认是GString,需要转换一下
        10.times {list.add("$it".toString())}
        list
    }

    @Newify([User]) //允许使用Python风格新建对象
    @GetMapping("/get/{id}")
    User getById(@PathVariable("id") Integer id){
        User(23,"Tom",23)  //lombok注解不识别
    }
}
