package com.ccb.springboot.service;

import com.ccb.springboot.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 业务层接口
 */

public interface UserService {

    // 增
    int addUser(User user);

    // 删
    int deleteUserById(Integer userId);

    // 改
    int updateUser(User user);

    // 查
    User selectUserById(Integer userId);

    List<User> selectAllUsers();    //新增，查询列表，UserMapper中记得添加这个方法


    //方法一：添加分页查询方法
    PageInfo<User> findAllUsers(int page, int pagesize);

    //方法二
    Page<User> findAllUserInfo(int page, int pagesize);
}
