package com.hou.mybatisplus.user.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum OrderTypeEnum {

    WECHAT(1,"微信订单"),
    STORE(2,"实体店订单");

    @EnumValue  //标识数据库字段,或者继承IEnum接口
    private Integer value;
    private String desc;

    OrderTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "OrderTypeEnum{" +
                "value=" + value +
                ", desc='" + desc + '\'' +
                '}';
    }
}
