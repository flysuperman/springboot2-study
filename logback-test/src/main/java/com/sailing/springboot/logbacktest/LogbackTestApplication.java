package com.sailing.springboot.logbacktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableCaching
@ServletComponentScan
@SpringBootApplication
public class LogbackTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogbackTestApplication.class, args);
    }

}
