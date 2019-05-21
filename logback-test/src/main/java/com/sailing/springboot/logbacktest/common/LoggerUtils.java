package com.sailing.springboot.logbacktest.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: Administrator
 * @Date: 2019/4/29 01:07
 * @Description:
 */
public class LoggerUtils {
    public static <T> Logger Logger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * 打印到指定的文件下
     *
     * @param desc 日志文件名称
     * @return
     */
    public static Logger Logger(LogFileName desc) {
        return LoggerFactory.getLogger(desc.getLogFileName());
    }
}
