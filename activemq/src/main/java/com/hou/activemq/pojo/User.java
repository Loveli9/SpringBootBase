package com.hou.activemq.pojo;

import lombok.Data;

import java.io.Serializable;

@Data   //需要实现序列化
public class User implements Serializable {

    private Integer id;
    private String name;

}
