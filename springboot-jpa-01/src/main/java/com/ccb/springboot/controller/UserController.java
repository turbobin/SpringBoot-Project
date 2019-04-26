package com.ccb.springboot.controller;


import com.ccb.springboot.domain.User;
import com.ccb.springboot.domain.UserRepository;
import com.ccb.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制层：调用业务层查询数据
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    //这里也可以直接把UserRepository注进来，直接调用接口方法
    @Autowired
    private UserRepository userRepository;

    //查询所有用户列表
    @RequestMapping(value = "/all")
    public List<User> selectAllUsers(){
        return userService.findAllUsers();
//        return userRepository.findAll();

    }

    //根据id查询用户
    @RequestMapping(value = "/id/{id}")
    public User selectUserById(@PathVariable("id") Integer userId) {
        return userService.findUserById(userId);
    }

    //根据用户名查询用户
    @RequestMapping(value = "/name/{name}")
    public User selectUserByName(@PathVariable("name") String username) {
        return userService.findUserByName(username);
    }

    //根据年龄查询数据
    @RequestMapping(value = "/age/{age}")
    public Object findUserByAge(@PathVariable("age") Integer age) {
        return userRepository.findUser(age);
    }
}
