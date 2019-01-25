package com.lonton.petstore.services.impl;

import com.lonton.petstore.entity.User;
import com.lonton.petstore.services.IUserService;
import com.lonton.petstore.services.exceptions.InsertDataException;
import com.lonton.petstore.services.exceptions.PasswordNotMatchException;
import com.lonton.petstore.services.exceptions.UserNotFoundException;
import com.lonton.petstore.services.exceptions.UsernameConflictException;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 用户功能测试类.
 *
 * @author xuwanxing
 */
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:Spring/spring-*.xml"})
public class UserServiceImplTest {
    @Autowired
    private IUserService userService;
    
    /**
     * 用户注册测试.
     */
    @Test
    public void register() {
        User user = new User();
        final int endIndex = 8;
        user.setUsername(UUID.randomUUID().toString().substring(0, endIndex));
        user.setPassword("you123");
        user.setPhone("13145784568");
        user.setGender(1);
        user.setEmail(UUID.randomUUID().toString().substring(0, endIndex) + "@foxmail.com");
        
        User result = null;
        try {
            result = userService.register(user);
        } catch (UsernameConflictException e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        } catch (InsertDataException e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
        log.info("result = " + result);
    }
    
    /**
     * 用户登录测试.
     */
    @Test
    public void login() {
        User user = null;
        try {
            user = userService.login("雷云", "123abc");
        } catch (UserNotFoundException e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        } catch (PasswordNotMatchException e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
        log.info("user = " + user);
    }
    
    /**
     * 通过用户名查询用户信息测试.
     */
    @Test
    public void getUserByUsername() {
        try {
            log.warn(userService.getUserByUsername("雷云"));
        } catch (Exception e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
    }
    
    /**
     * 通过用户id查询用户信息测试.
     */
    @Test
    public void getUserById() {
        try {
            final int uid = 9;
            log.warn("User = " + userService.getUserById(uid));
        } catch (Exception e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
    }
    
    /**
     * 修改用户信息测试.
     */
    @Test
    public void updateInfo() {
        try {
            final int uid = 9;
            log.warn("修改前" + userService.getUserById(uid));
            User user = new User();
            user.setId(uid);
            user.setUsername("臧彦晋1");
            user.setPhone("16545487256");
            user.setAvatar("upload/abc.jpg");
            userService.updateUserInfo(user);
            log.warn("修改后" + userService.getUserById(uid));
        } catch (Exception e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
    }
}