package com.sailing.exceptiontest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/28 23:51
 * @Description:
 */


@Data
public class UserInfo {

    @Id
    private String uid;

    private String userName;

    private String passWord;

    private Integer age;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date birth;

}
