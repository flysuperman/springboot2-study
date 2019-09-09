package com.sailing.exceptiontest.common.result;

public class ResultUtil {

    private static  boolean sucess_status=true;

    private static boolean  fail_status = false;

    /**
     * 成功不带数据
     * @return
     */
    public static ResponseResult success(){
        return  success(null);
    }

    /**
     * 成功带数据
     * @param data
     * @return
     */
    public static ResponseResult success(Object data){
        return new ResponseResult(ResponseEnum.SUCCESS,sucess_status,data);
    }

    public static ResponseResult success(Object data,Long total){
        return new ResponseResult(ResponseEnum.SUCCESS,sucess_status,data,total);
    }
    /**
     * 系统异常返回结果
     * @return
     */
    public static ResponseResult error(){
        return new ResponseResult(ResponseEnum.SYSTEM_ERROR,fail_status);
    }

    /**
     * 返回错误信息
     * @param responseEnum
     * @return
     */
    public static ResponseResult error(ResponseEnum responseEnum){
        return new ResponseResult(responseEnum,fail_status);
    }

    public static ResponseResult result(ResponseEnum responseEnum,boolean status){
        return  new ResponseResult(responseEnum,status);
    }

    public static ResponseResult result(ResponseEnum responseEnum,boolean status,Object data){
        return  new ResponseResult(responseEnum,status,data);
    }

    public static ResponseResult result(ResponseEnum responseEnum,boolean status,Object data,Long total){
        return  new ResponseResult(responseEnum,status,data,total);
    }
    /**
     * 通用返回结果
     * @param code
     * @param msg
     * @param status 返回状态：true:成功,false:失败
     * @return
     */
    public static ResponseResult result(String code,String msg,boolean status){
        return  new ResponseResult(code,msg,status);
    }

    /**
     *  通用带数据返回结果
     * @param code
     * @param msg
     * @param status 返回状态：true:成功,false:失败
     * @param data
     * @return
     */
    public static ResponseResult result(String code,String msg,boolean status,Object data){
        return  new ResponseResult(code,msg,status,data);
    }

    /**
     *  通用带数据返回结果
     * @param code
     * @param msg
     * @param status 返回状态：true:成功,false:失败
     * @param data
     * @return
     */
    public static ResponseResult result(String code,String msg,boolean status,Object data,Long total){
        return  new ResponseResult(code,msg,status,data,total);
    }

}
