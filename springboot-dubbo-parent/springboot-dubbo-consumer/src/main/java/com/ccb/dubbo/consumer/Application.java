package com.ccb.dubbo.consumer;

import com.ccb.dubbo.consumer.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

//@EnableDubbo  //注释，改用xml加载
@SpringBootApplication
@ImportResource(value = {"classpath:dubbo/*.xml"})
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        UserController bean = run.getBean(UserController.class);
        System.out.println(bean.userService.sayHello("turbobin"));

    }

}

