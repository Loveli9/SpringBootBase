package com.hou.springmvc.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyUser {

    private Integer id;

    private String name;


    public static void main(String[] args) {
        String str01="40";
        String str02="3";
        System.out.println(str01.compareTo(str02));
    }

}
