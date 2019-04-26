package com.ccb.dubbo.common.mapper;

import com.ccb.dubbo.common.model.User;
//import org.apache.ibatis.annotations.Mapper;
//import org.springframework.stereotype.Component;

import java.util.List;

//@Mapper
//@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUsers();    //需要在UserMapper.xml中添加
}