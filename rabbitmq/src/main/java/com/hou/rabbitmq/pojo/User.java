package com.hou.rabbitmq.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    private String id;
    private String name;
}
