package com.hou.web.web03;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    //只在本Controller有效
    @ExceptionHandler(value = Exception.class)
    public String error(Exception e) {
        //可以根据参数获取具体异常信息
        return "found Exception:" + e.getMessage();
    }

    @GetMapping("/list")
    public String list() {
        return "list";
    }

}
