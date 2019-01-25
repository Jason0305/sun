package com.lonton.petstore.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer gender;
    private String email;
    private String phone;
    private String avatar;
    private String salt;
    private Integer grade;
    private Integer status;
    private Date lastLogin;
    private Date createdTime;
    
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
    
    public User(Integer id, String username, String password, Integer gender, String email,
                String phone, String avatar, String salt, Integer grade, Integer status,
                Date lastLogin, Date createdTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.salt = salt;
        this.grade = grade;
        this.status = status;
        this.lastLogin = lastLogin;
        this.createdTime = createdTime;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public Integer getGender() {
        return this.gender;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public String getAvatar() {
        return this.avatar;
    }
    
    public String getSalt() {
        return this.salt;
    }
    
    public Integer getGrade() {
        return this.grade;
    }
    
    public Integer getStatus() {
        return this.status;
    }
    
    public Date getLastLogin() {
        return this.lastLogin;
    }
    
    public Date getCreatedTime() {
        return this.createdTime;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$avatar = this.getAvatar();
        final Object other$avatar = other.getAvatar();
        if (this$avatar == null ? other$avatar != null : !this$avatar.equals(other$avatar)) return false;
        final Object this$salt = this.getSalt();
        final Object other$salt = other.getSalt();
        if (this$salt == null ? other$salt != null : !this$salt.equals(other$salt)) return false;
        final Object this$grade = this.getGrade();
        final Object other$grade = other.getGrade();
        if (this$grade == null ? other$grade != null : !this$grade.equals(other$grade)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$lastLogin = this.getLastLogin();
        final Object other$lastLogin = other.getLastLogin();
        if (this$lastLogin == null ? other$lastLogin != null : !this$lastLogin.equals(other$lastLogin)) return false;
        final Object this$createdTime = this.getCreatedTime();
        final Object other$createdTime = other.getCreatedTime();
        if (this$createdTime == null ? other$createdTime != null : !this$createdTime.equals(other$createdTime))
            return false;
        return true;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $avatar = this.getAvatar();
        result = result * PRIME + ($avatar == null ? 43 : $avatar.hashCode());
        final Object $salt = this.getSalt();
        result = result * PRIME + ($salt == null ? 43 : $salt.hashCode());
        final Object $grade = this.getGrade();
        result = result * PRIME + ($grade == null ? 43 : $grade.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $lastLogin = this.getLastLogin();
        result = result * PRIME + ($lastLogin == null ? 43 : $lastLogin.hashCode());
        final Object $createdTime = this.getCreatedTime();
        result = result * PRIME + ($createdTime == null ? 43 : $createdTime.hashCode());
        return result;
    }
    
    public String toString() {
        return "User(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", gender=" + this.getGender() + ", email=" + this.getEmail() + ", phone=" + this.getPhone() + ", avatar=" + this.getAvatar() + ", salt=" + this.getSalt() + ", grade=" + this.getGrade() + ", status=" + this.getStatus() + ", lastLogin=" + this.getLastLogin() + ", createdTime=" + this.getCreatedTime() + ")";
    }
}