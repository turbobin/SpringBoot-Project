package com.ccb.springcloud.comsumer.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableHystrix              // 开启容错机制
@EnableDiscoveryClient      // 声明这是Eureka的客户端
@ComponentScan(basePackages = {"com.ccb.springcloud.comsumer"})
@MapperScan(basePackages = {"com.ccb.springcloud.comsumer.common.mapper"})
@SpringBootApplication
public class OrderApplication {

    @Bean
    @LoadBalanced       //开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
