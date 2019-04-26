package com.ccb.springboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 数据访问接口
 */
public interface UserRepository extends JpaRepository<User, Long> {

//    List<User> findALL();     //继承JpaRepository，已实现findALL方法

    User findUserById(Integer id);

    User findUserByUsername(String name);

    @Query("from User u where u.age=:age")  //注意这里User表示实体类名
    List<User> findUser(@Param("age") Integer age);
}
