package com.lonton.petstore.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * 存储用户注册信息的User类。
 *
 * @Author xuwanxing
 */
@Data
public class User {
    public static final int ONLINE  = 1;
    public static final int OFFLINE = 0;
    
    private int    id;
    private String username;
    private String password;
    private int    gender;
    private String email;
    private String phone;
    private String avatar;
    private String salt;
    private int    status;
    private int    isDelete;
    private String createdUser;
    private Date   createdTime;
    private String modifiedUser;
    private String modifiedTime;
    
    public User() {
        super();
    }
    
    public User(String username, String password, int gender, String email, String phone) {
        
        super();
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }
}
