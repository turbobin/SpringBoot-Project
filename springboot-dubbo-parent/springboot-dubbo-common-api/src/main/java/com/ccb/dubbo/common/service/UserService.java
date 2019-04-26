package com.ccb.dubbo.common.service;



import com.ccb.dubbo.common.model.User;

import java.util.List;

/**
 * 用户业务层增删改查接口
 */
public interface UserService {

    String sayHello(String name);

    int addUser(User user);

    User findUserById(Integer userId);

    List<User> findAllUsers();      //一会在UserMapper.xml中添加这个方法

    int updateUser(User user);

    int deleteUserById(Integer userId);
}
