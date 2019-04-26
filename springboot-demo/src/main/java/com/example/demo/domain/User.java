package com.example.demo.domain;

/**
 * 实体类
 */
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private String city;

    //省略getter、setter和构造方法

    public User() {
    }

    public User(Integer id, String name, Integer age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.city = city;
    }
}
