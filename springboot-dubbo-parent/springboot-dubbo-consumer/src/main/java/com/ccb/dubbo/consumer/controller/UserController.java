package com.ccb.dubbo.consumer.controller;

import com.ccb.dubbo.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;


@RestController
@RequestMapping(value = "user")
public class UserController {

//    @Reference(version = "1.0.0")   //注释，采用xml配合spring注解方式注入
    @Autowired(required = false)
    public UserService userService;

    @RequestMapping(value = "/all")
    public Object findAllUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/{id}")
    public Object findUserById(@PathVariable("id") Integer userId){
        return userService.findUserById(userId);
    }

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return userService.sayHello(name);
    }


}
