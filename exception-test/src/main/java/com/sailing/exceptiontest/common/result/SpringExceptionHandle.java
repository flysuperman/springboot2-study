package com.sailing.exceptiontest.common.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.validation.BindException;

import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;
import java.sql.SQLException;

/**
 * 统一异常处理
 * @RestControllerAdvice和 @ControllerAdvice区别
 * 1、类似于@RestController 与 @Controller的区别
 * 2、如果用@ControllerAdvice就需要在返回结果上面增加 @ResponseBody
 */
@Slf4j
@RestControllerAdvice
public class SpringExceptionHandle {


    /**
     * 请求参数类型错误异常的捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value={BindException.class})
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ResponseResult badRequest(BindException e){
        log.error("occurs error when execute method ,message {}",e.getMessage());
        return ResultUtil.error(ResponseEnum.ORTHER_ERROR);
    }

    /**
     * 数据库操作出现异常
     * @param e
     * @return
     */
    @ExceptionHandler(value={SQLException.class,DataAccessException.class})
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult systemError(Exception e){
        log.error("occurs error when execute method ,message {}",e.getMessage());
        return ResultUtil.error(ResponseEnum.ORTHER_ERROR);
    }


    /**
     * 404错误异常的捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseResult badRequestNotFound(BindException e){
        log.error("occurs error when execute method ,message {}",e.getMessage());
        return ResultUtil.error(ResponseEnum.ORTHER_ERROR);
    }

//    /**
//     * 处理RuntimeException异常，包括自定义异常
//     * @param e
//     * @param request
//     * @return
//     */
//    @ExceptionHandler(RuntimeException.class)
//   public ResponseResult handleRuntimeException(RuntimeException e,HttpServletRequest request){
//        String requestURI = request.getRequestURI();
//        String errorMsg = "出现错误的请求URL:{},消息:{},异常信息:";
//        if(e instanceof NullPointerException){
//            log.error(errorMsg,requestURI,ResponseEnum.NULL_PARAM_ERROR.getMsg(),e);
//            return ResultUtil.error(ResponseEnum.NULL_PARAM_ERROR);
//        } else {
//            log.error(errorMsg,requestURI,ResponseEnum.ORTHER_ERROR.getMsg(),e);
//            return ResultUtil.error(ResponseEnum.ORTHER_ERROR);
//        }
//    }

    /**
     * 网络连接失败！
     * @param e
     * @return
     */
    @ExceptionHandler(value={ConnectException.class})
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult connect(Exception e){
        log.error("occurs error when execute method ,message {}",e.getMessage());
        return ResultUtil.error(ResponseEnum.ORTHER_ERROR);
    }

    @ExceptionHandler(value={Exception.class})
    @ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseResult notAllowed(Exception e){
        log.error("occurs error when execute method ,message {}",e.getMessage());
        return  ResultUtil.error( ResponseEnum.METHOD_NOT_ALLOWED);
    }

}
