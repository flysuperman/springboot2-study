package com.sailing.exceptiontest.web;

import com.sailing.exceptiontest.common.result.ResponseResult;
import com.sailing.exceptiontest.common.result.ResultUtil;
import com.sailing.exceptiontest.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2019/4/29 00:55
 * @Description:
 */

@Api
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "查询所有用户", notes = "查询出系统所有用户")
    @GetMapping("findAll")
    public ResponseResult findAll(){
        ResponseResult result =  ResultUtil.success(userInfoService.findAll());
        System.out.println(result);
        return result;
    }
}
