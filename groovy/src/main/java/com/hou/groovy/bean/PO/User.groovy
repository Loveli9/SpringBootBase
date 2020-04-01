package com.hou.groovy.bean.PO

import lombok.NoArgsConstructor
import org.apache.ibatis.type.Alias

@NoArgsConstructor
@Alias("user")
class User {
    Integer id
    String name
    Integer age

    User(Integer id, String name, Integer age) {
        this.id = id
        this.name = name
        this.age = age
    }
}
