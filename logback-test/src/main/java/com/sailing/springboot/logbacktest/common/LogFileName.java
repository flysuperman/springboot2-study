package com.sailing.springboot.logbacktest.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: Administrator
 * @Date: 2019/4/29 01:08
 * @Description:
 */
public enum LogFileName {
    //配置到logback.xml中的logger name="vipUser"
    XJK_USER("xjkUser"), BAITIAO_USER("baitiaoUser");
    private String logFileName;

    LogFileName(String fileName) {
        this.logFileName = fileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public static LogFileName getAwardTypeEnum(String value) {
        LogFileName[] arr = values();
        for (LogFileName item : arr) {
            if (null != item && StringUtils.isNotBlank(item.logFileName)) {
                return item;
            }
        }
        return null;
    }

}
