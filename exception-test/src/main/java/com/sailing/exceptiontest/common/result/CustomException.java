package com.sailing.exceptiontest.common.result;

import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class CustomException extends  RuntimeException{

    private String code;

    private String msg;

    //打印的日志信息
    private String message;


    public CustomException(ResponseEnum responseEnum){
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

    public CustomException(ResponseEnum responseEnum,String message){
        this(responseEnum);
        this.message = message;
    }
}
