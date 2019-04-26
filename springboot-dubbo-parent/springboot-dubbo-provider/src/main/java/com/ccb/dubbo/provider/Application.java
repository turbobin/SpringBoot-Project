package com.ccb.dubbo.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@EnableDubbo  //注释，改用xml加载
@MapperScan(basePackages = {"com.ccb.dubbo.common.mapper"})
@SpringBootApplication
@ImportResource(value = {"classpath:dubbo/*.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

