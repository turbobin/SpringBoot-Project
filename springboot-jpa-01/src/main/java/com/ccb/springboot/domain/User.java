package com.ccb.springboot.domain;

import javax.persistence.*;

@Entity     //标注为数据库对应实体类
@Table(name = "users")  //当表名和实体名称不一致时，必须声明
public class User {

    @Id
    @GeneratedValue     //标注主键自增
    private Integer id;

    @Column(length = 40)    //声明实体类属性，length只对String类型有效
    private String username;

    @Column(length = 50)
    private String password;

    @Column(length = 40)
    private String email;

    @Column(length = 10)
    private String sex;

    @Column
    private Integer age;

    @Column(length = 30)
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }
}