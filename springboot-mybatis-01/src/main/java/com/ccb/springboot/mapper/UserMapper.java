package com.ccb.springboot.mapper;

import com.ccb.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository //注册DAO到spring容器中
//@Mapper     // mybatis注解，标注mapper,或者在启动类标注@MapperScan(basePackages = {"com.ccb.springboot.mapper"})
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    List<User> selectAllUsers();    // 新增查询列表方法，需要对应在UserMapper.xml中添加

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
}