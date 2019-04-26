package com.ccb.springboot.service.impl;

import com.ccb.springboot.entity.User;
import com.ccb.springboot.mapper.UserMapper;
import com.ccb.springboot.service.UserService;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUserById(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selectUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public PageInfo<User> findAllUsers(int page, int pagesize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(page, pagesize);
        List<User> users = userMapper.selectAllUsers();
//        PageInfo<User> all = new PageInfo<>(users);
        return new PageInfo<>(users);
    }

    //方法二
    @Override
    public Page<User> findAllUserInfo(int page, int pagesize) {

//        Page<User> resultlist = PageHelper.startPage(page, pagesize, true)
//                .doSelectPage(new ISelect() {
//                    @Override
//                    public void doSelect() {
//                        userMapper.selectAllUsers();
//                    }
//                });
        //上述改成 lambda表达式
        Page<User> resultlist = PageHelper.startPage(page, pagesize, true)
                .doSelectPage(() -> userMapper.selectAllUsers());
        return resultlist;
    }


}
