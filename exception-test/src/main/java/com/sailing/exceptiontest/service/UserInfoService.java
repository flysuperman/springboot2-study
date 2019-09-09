package com.sailing.exceptiontest.service;

import com.sailing.exceptiontest.dao.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/4/28 23:50
 * @Description:
 */
@Service
public class UserInfoService {

    private final static Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Resource
    private UserInfoMapper userInfoMapper;
    public List findAll(){
        return userInfoMapper.selectAll();
    }
}
