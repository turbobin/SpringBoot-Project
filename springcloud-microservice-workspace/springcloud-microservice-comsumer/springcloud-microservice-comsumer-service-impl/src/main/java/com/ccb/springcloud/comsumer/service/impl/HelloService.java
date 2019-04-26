package com.ccb.springcloud.comsumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")      // 必须加在一级方法上
    public String hello() {

        return sayHello();
//        String string = restTemplate.getForObject("httpa://HELLO-SERVICE/hello", String.class);
//        System.out.println("string:" + string);
//        return string;
    }

//    @HystrixCommand(fallbackMethod = "helloError")  // 加在这里不会起作用
    private String sayHello() {
        String string = restTemplate.getForObject("httpa://HELLO-SERVICE/hello", String.class);
        System.out.println("string:" + string);
        return string;
    }

    public String helloError() {
        return "服务故障了";
    }
}
