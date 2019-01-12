package com.lonton.petstore.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String  username;
    private String  password;
    private Integer gender;
    private String  email;
    private String  phone;
    private String  avatar = "-1";
    private String  salt;
    private Integer grade;
    private Integer status;
    private Date    lastLogin;
    private Date    createdTime;
    
    public User() {
        super();
    }
    
    public User(String username, String password, Integer gender, String email, String phone) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }
    
}