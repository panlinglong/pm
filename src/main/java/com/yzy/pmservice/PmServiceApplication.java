package com.yzy.pmservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yzy.pmservice.mapper")
public class PmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmServiceApplication.class, args);
    }

}
