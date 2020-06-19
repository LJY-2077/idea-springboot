package com.cn.lijy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cn.lijy.mapper")
public class SpringbootDemoV1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoV1Application.class, args);
    }

}
