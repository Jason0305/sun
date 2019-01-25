package com.lonton.petstore.entity;

import java.util.Date;

/**
 * 存储用户注册信息的User类。
 *
 * @Author xuwanxing
 */
//@Data
//@RequiredArgsConstructor
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
    
    public User(String username, String password, int gender, String email, String phone) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", salt='" + salt + '\'' +
                ", status=" + status +
                ", isDelete=" + isDelete +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }
    
    public User() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getGender() {
        return gender;
    }
    
    public void setGender(int gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getSalt() {
        return salt;
    }
    
    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getIsDelete() {
        return isDelete;
    }
    
    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
    public String getCreatedUser() {
        return createdUser;
    }
    
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }
    
    public Date getCreatedTime() {
        return createdTime;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
    public String getModifiedUser() {
        return modifiedUser;
    }
    
    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    
    public String getModifiedTime() {
        return modifiedTime;
    }
    
    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
