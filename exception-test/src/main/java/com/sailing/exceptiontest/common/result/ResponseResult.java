package com.sailing.exceptiontest.common.result;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 响应对象
 * @param <T>
 */
@Data
@ToString
public class ResponseResult<T> {

    private T data;

    private String code;

    private String msg;

    //响应状态 true:成功,false:失败
    private boolean status;

    /** 响应数据总量 */
    private long total = 0L;


    public ResponseResult(String code,String msg,boolean status){
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public ResponseResult(String code,String msg,boolean status,T data){
        this(code,msg,status);
        this.data = data;
    }

    public ResponseResult(String code,String msg,boolean status,T data,Long total){
        this(code,msg,status,data);
        this.total = total;
    }

    public ResponseResult(ResponseEnum responseEnumItem,boolean status){
        this.code = responseEnumItem.getCode();
        this.msg = responseEnumItem.getMsg();
        this.status = status;
    }

    public ResponseResult(ResponseEnum responseEnumItem,boolean status, T data){
        this(responseEnumItem,status);
        this.data = data;
    }

    public ResponseResult(ResponseEnum responseEnumItem,boolean status,T data,Long total){
        this(responseEnumItem,status,data);
        this.total = total;
    }

}
