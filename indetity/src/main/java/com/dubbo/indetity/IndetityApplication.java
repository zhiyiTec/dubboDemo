package com.dubbo.indetity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableDubbo(scanBasePackages="com.dubbo.indetity.service.impl")
@SpringBootApplication
//mapper 接口类扫描包配置
@MapperScan("com.dubbo.indetity.mapper")
public class IndetityApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndetityApplication.class, args);
    }

}
