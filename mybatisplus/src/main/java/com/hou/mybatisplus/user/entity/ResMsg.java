package com.hou.mybatisplus.user.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResMsg<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    //请求返回状态码
    private Integer code;

    private String message;

    private T data;  //泛型数据


    public void  pushData(T data){
        this.data=data;
    }

    public static ResMsg success(){
        return new ResMsg(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage());
    }

    public static ResMsg success(ErrorCode systemHttpInfo){
        return new ResMsg(systemHttpInfo.getCode(),systemHttpInfo.getMessage());
    }

    public static ResMsg success(String messgae){
        return new ResMsg(ErrorCode.SUCCESS.getCode(), messgae);
    }

    public static <T> ResMsg success(T obj){
        return new ResMsg(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(),obj);
    }

    public static ResMsg failture(ErrorCode systemHttpInfo){
        return new ResMsg(systemHttpInfo.getCode(),systemHttpInfo.getMessage());
    }
    public static ResMsg failture(){
        return new ResMsg(ErrorCode.FAIL.getCode(),ErrorCode.FAIL.getMessage());
    }

    public static ResMsg newErrorsMessage(String message){
        return new ResMsg(ErrorCode.FAIL.getCode(), message);
    }

    public ResMsg() {}

    public ResMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResMsg(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
