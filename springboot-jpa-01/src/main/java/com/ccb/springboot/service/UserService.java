package com.ccb.springboot.service;

import com.ccb.springboot.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findUserById(Integer id);

    User findUserByName(String name);
}
