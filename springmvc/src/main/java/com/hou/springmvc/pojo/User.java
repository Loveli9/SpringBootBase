package com.hou.springmvc.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.util.Date;

//数据验证测试
@Data
@Component
public class User {

    @NotNull(message = "id不能为空")
    private Long id;

    //@Future(message = "时间只能是未来")
    @Past(message = "时间只能是过去")
    @DateTimeFormat(pattern = "yyyy-MM-dd") //格式转换
    private Date date;

    @DecimalMax(value = "100000.00",message = "不能超过100000") //最大值
    @DecimalMin(value = "0.1",message = "不能小于0.1")  //最小值
    private Double money;

    //@Range(min = 1,max = 100)  //1-100之间的范围内
    @Max(100) //最大值
    @Min(1)  //最小值
    private Integer age;

    //message: 格式不正确时返回信息
    @Email(message = "邮箱格式错误")
    private String email;

    @Size(min = 5,max = 50) //字符串长度范围
    private String size;

}
