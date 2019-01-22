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

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:Spring/spring-*.xml"})
public class UserServiceImplTest {
    @Autowired
    private IUserService iUserService;
    
    @Test
    public void register() {
        User user = new User();
        user.setUsername("Lily2");
        user.setPassword("you");
        user.setGender(1);
        user.setEmail("lily.c@foxmail.com");
        
        User result = null;
        try {
            result = iUserService.register(user);
        } catch (UsernameConflictException e) {
            e.printStackTrace();
        } catch (InsertDataException e) {
            e.printStackTrace();
        }
        log.info("result = " + result);
    }
    
    @Test
    public void login() {
        User user = null;
        try {
            user = iUserService.login("Lily", "you");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (PasswordNotMatchException e) {
            e.printStackTrace();
        }
        log.info("user = " + user);
    }
}