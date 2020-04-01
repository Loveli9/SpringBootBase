package com.hou.web.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 使用freemarker
 * 默认的freemarker的模板文件在classpath:/templates/下
 * 默认扩展名为ftl
 * 修改默认路径:配置文件中修改,多个可以用,隔开
 * 例如:spring.freemarker.templateLoaderPath=classpath:/ftl
 */
@Controller
public class AccountController {

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @GetMapping("/layout")
    public String layout(Model model) {
        model.addAttribute("username", "username");
        return "layout";
    }

}
