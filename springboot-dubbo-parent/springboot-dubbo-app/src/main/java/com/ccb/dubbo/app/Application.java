package com.ccb.dubbo.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 可以把App单独放一起，配置@ComponentScan(basePackages = {"com.ccb.dubbo.*"})
 * 就可以启动相应的服务
 */
//@EnableDubbo  //注释，改用xml加载
@ComponentScan(basePackages = {"com.ccb.dubbo.provider"})
@MapperScan(basePackages = {"com.ccb.dubbo.common.mapper"})
@SpringBootApplication
@ImportResource(value = {"classpath:dubbo/*.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

