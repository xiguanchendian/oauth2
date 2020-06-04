package com.xgcd.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xgcd.mapper")
@SpringBootApplication
public class Oauth2Application {

    public static void main(String[] args)  {
        SpringApplication.run(Oauth2Application.class, args);
    }

}
