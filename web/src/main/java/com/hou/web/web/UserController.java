package com.hou.web.web;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @ResponseBody
    @RequestMapping(value = "/user")
    public String Hello() {
        return "hello springboot";

    }

    /**
     * @GetMapping:Spring4.3新特性,只支持get请求
     * @PostMapping,@PutMapping同理
     * @RequestParam:传递参数:value:指定参数名字 defaultValue:默认值,可选
     * required:是否必须
     */
    @ResponseBody
    @GetMapping("/getmapping")
    public String get(@RequestParam(value = "username", defaultValue = "houzheng") String usrename,
                      @RequestParam(value = "password", required = true) String password) {
        return "get springboot" + usrename + "---" + password;

    }

    /**
     * @PathParam:获取url中的参数 , 可直接注入servlet的api
     */
    @ResponseBody
    @PostMapping("/postmapping/{id}")
    public String post(@PathParam("id") String id, HttpServletRequest req) {
        req.getRemoteHost();
        return "post springboot";
    }


}
