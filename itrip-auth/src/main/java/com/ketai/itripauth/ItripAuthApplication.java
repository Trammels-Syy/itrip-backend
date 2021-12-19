package com.ketai.itripauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.ketai.mapper")
@ComponentScan({"com.ketai.commom","com.ketai.itripauth"})
public class ItripAuthApplication {

    public static void main (String[] args) {
        SpringApplication.run(ItripAuthApplication.class, args);
    }

}
