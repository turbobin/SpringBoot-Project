package com.ccb.springcloud.provider.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient      // 声明这是Eureka的客户端
@ComponentScan(basePackages = {"com.ccb.springcloud.provider"})
@MapperScan(basePackages = {"com.ccb.springcloud.provider.common.mapper"})
@SpringBootApplication
public class ItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class, args);
    }
}
