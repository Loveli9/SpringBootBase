package com.hou.mybatisplus.user.entity;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {
    SUCCESS(0,"操作成功!"),
    FAIL(-1,"操作失败！"),
    LACK_PARAM(11, "缺少参数"),
    UNKOWN_ERROR(12, "未知错误"),
    SYS_ERROR(13, "系统错误"),
    ARG_CAN_NOT_BE_EMPTY(14, "参数不能为空"),

    ;

    public static Map<Integer,ErrorCode> map=new HashMap<>();
    static {
        for (ErrorCode value : ErrorCode.values()) {
            map.put(value.code,value);
        }
    }

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    private Integer code;
    private String message;
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
