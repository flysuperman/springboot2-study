package com.sailing.exceptiontest.common.operatelog;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.sailing.exceptiontest.common.result.CustomException;
import com.sailing.exceptiontest.common.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/9/9 21:23
 * @Description:
 */

@Component
@Aspect
@Order(1)
@Slf4j
public class OpLogAspect {

    @Value("${log.enable}")
    private  boolean enableLogFlag;

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object validate(ProceedingJoinPoint pjp) throws Throwable{
        if (!enableLogFlag) {
            log.warn("日志切面：enableLog=false，不记录日志！");
            return pjp.proceed();
        }
        System.out.println("执行controller 开始："+pjp.getSignature()+" 参数："+Lists.newArrayList(pjp.getArgs()));
        //检查参数
        checkRequestParam(pjp);
        Object result = pjp.proceed(pjp.getArgs());
        return result;
    }

    private void checkRequestParam(ProceedingJoinPoint pjp){
        String param = String.valueOf(pjp.getArgs());
        if(!LogUtil.sqlStrFilter(param)){
            System.out.println("访问接口:"+pjp.getSignature()+",输入参数存在sql注入风险，参数为"+Lists.newArrayList(pjp.getArgs()));
            throw new CustomException(ResponseEnum.SQL_INJECTION_ERROR);
        }

        if(!LogUtil.isIllegalStr(param)){
            System.out.println("访问接口:"+pjp.getSignature()+",输入参数含有非法字符，参数为"+Lists.newArrayList(pjp.getArgs()));
            throw new CustomException(ResponseEnum.ILLEGAL_CHARACTER_ERROR);
        }
    }
}
