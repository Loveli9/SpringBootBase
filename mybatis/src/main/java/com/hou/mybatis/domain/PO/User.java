package com.hou.mybatis.domain.PO;

import com.hou.mybatis.domain.ENUM.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.ibatis.type.Alias;

@AllArgsConstructor  //提供全参构造器
@NoArgsConstructor  //提供无参构造器
@Data   //提供所有字段的get,set方法和toString,equals,hasCode,canEqual方法
@Alias("user")
public class User {
    //@NonNull   //非空检查
    private String id;
    private String name;
    //private SexEnum sex;
    private Integer age;

}
