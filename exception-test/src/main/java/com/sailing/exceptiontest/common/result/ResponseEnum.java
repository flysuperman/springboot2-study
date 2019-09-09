package com.sailing.exceptiontest.common.result;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * 响应枚举
 */


public enum ResponseEnum {


    SUCCESS("200","操作成功"),
    SYSTEM_ERROR("-001","系统异常"),
    BAD_REQUEST("-002","错误的请求参数"),
    NOT_FOUND("-003","找不到请求路径！"),
    CONNECTION_ERROR("-004","网络连接请求失败！"),
    METHOD_NOT_ALLOWED("-005","不合法的请求方式"),
    NULL_PARAM_ERROR("-100","参数为空异常"),
    SQL_INJECTION_ERROR("-101","输入参数存在sql注入风险"),
    ILLEGAL_CHARACTER_ERROR("-102","非法字符错误"),
    ORTHER_ERROR("-300","其它异常");
    //数据响应码
    private String code;

    //数据响应信息
    private String msg;


    private ResponseEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
