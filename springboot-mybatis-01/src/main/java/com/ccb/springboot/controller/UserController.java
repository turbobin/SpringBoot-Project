package com.ccb.springboot.controller;

import com.ccb.springboot.entity.User;
import com.ccb.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    //查询所有用户列表
    @RequestMapping(value = "/all")
    public List<User> selectAllUsers() {
        return userService.selectAllUsers();

    }

    //根据id查询用户
    @RequestMapping(value = "/{id}")
    public User selectUserById(@PathVariable("id") Integer userId) {
        return userService.selectUserById(userId);
    }

    //根据id 更新数据库
    @RequestMapping("/update/{id}")
    public int updateUserById(@PathVariable("id") Integer userId) {
        User user = userService.selectUserById(userId);
        user.setPassword("666666");
        System.out.println("userId = [" + userId + "]");
        return userService.updateUser(user);
    }

    //分页查询
    @GetMapping("/pagehelper")
    public Object findAllUsers(
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int page,
            @RequestParam(name = "pagesize", required = false, defaultValue = "2")
                    int pagesize) {
//        return userService.findAllUsers(page, pagesize);
        return userService.findAllUserInfo(page, pagesize);
    }

}
