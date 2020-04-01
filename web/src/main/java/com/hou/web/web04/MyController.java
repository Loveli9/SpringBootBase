package com.hou.web.web04;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/list")
    public String list() {
        return "list";
    }

}
