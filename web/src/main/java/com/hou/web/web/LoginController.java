package com.hou.web.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    /**
     * 跳转指定的jsp页面
     */
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username) {
        if ("root".equals(username)) {
            return "ok";
        }
        return "login";
    }

    /**
     * 给jsp传参数,类似于req.setAttrtibute
     */
    @RequestMapping("/sign")
    public String sign(@RequestParam("username") String username, Model model) {
        model.addAttribute("username", username);
        return "index";
    }

}
