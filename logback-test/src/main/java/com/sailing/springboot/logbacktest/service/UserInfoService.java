package com.sailing.springboot.logbacktest.service;

import com.sailing.springboot.logbacktest.common.LogFileName;
import com.sailing.springboot.logbacktest.common.LoggerUtils;
import com.sailing.springboot.logbacktest.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/4/28 23:50
 * @Description:
 */

@Service
public class UserInfoService {


    private final static Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    Logger XJK_USER_LOG = LoggerUtils.Logger(LogFileName.XJK_USER);
    Logger BAITIAO_USER_LOG = LoggerUtils.Logger(LogFileName.BAITIAO_USER);

    public List findAll(){
        XJK_USER_LOG.info("业务日志");
        List list =new ArrayList<UserInfo>();
        for(int i=0;i<2;i++){
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName("zhang san"+i);
            userInfo.setPassWord("pw+"+i);
            list.add(userInfo);
        }
        XJK_USER_LOG.info("查询结束");
        return list;
    }
}
