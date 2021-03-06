package com.sailing.exceptiontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2
@MapperScan("com.sailing.exceptiontest.dao")
@SpringBootApplication(scanBasePackages = "com.sailing.exceptiontest.*")
public class ExceptionTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionTestApplication.class, args);
    }

}
