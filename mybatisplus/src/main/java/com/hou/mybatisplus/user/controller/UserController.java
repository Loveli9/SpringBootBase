package com.hou.mybatisplus.user.controller;


import com.hou.mybatisplus.user.entity.ResMsg;
import com.hou.mybatisplus.user.service.LamdbaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 侯征
 * @since 2019-07-11
 */
@RestController
@RequestMapping("/user/user")
public class UserController implements LamdbaService {


    //测试ResMsg返回值去除data层,直接按添加数据返回
    @GetMapping("test/{id}")
    public ResMsg testmsg(@PathVariable("id") Integer id){
        return repsSuccessMsg(id,x->x+1);
    }



}
