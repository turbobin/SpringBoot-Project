package com.ccb.dubbo.provider.service.impl;

import com.ccb.dubbo.common.mapper.UserMapper;
import com.ccb.dubbo.common.model.User;
import com.ccb.dubbo.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

//import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Service;

//@Service(version = "1.0.0")
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User findUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUserById(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
}
