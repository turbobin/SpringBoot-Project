package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service       //Spring注解，用于注册业务层
public class UserServiceImpl implements UserService {

    private static final Map<Integer, User> MAP = new HashMap<Integer, User>();

    //准备一些静态数据
    static {

        MAP.put(1, new User(1, "张三", 26, "上海"));
        MAP.put(2, new User(2, "李四", 23, "北京"));
        MAP.put(3, new User(3, "王五", 25, "深圳"));
    }
    @Override
    public User findUserById(Integer id) {
        return MAP.get(id);
    }
}
