package com.feri.pay_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.feri.pay_api.mapper")
@EnableSwagger2
@EnableTransactionManagement
public class PayApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApiApplication.class, args);
    }
}