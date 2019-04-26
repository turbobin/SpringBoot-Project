package com.example.demo.service;

import com.example.demo.domain.User;

/**
 * 业务层接口
 */
public interface UserService {

    public User findUserById(Integer id);
}
