package com.lonton.petstore.services.impl;

import com.lonton.petstore.entity.User;
import com.lonton.petstore.services.IUserService;
import com.lonton.petstore.services.exceptions.DataInsertException;
import com.lonton.petstore.services.exceptions.PasswordNotMatchException;
import com.lonton.petstore.services.exceptions.UserNotFoundException;
import com.lonton.petstore.services.exceptions.UsernameConflictException;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class UserServiceImplTest {
    @Autowired
    private IUserService iUserService;
    private Logger logger ;

    @Before
    public void setUp() {
        logger = Logger.getLogger(UserServiceImpl.class);
    }

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
        } catch (DataInsertException e) {
            e.printStackTrace();
        }
        logger.info("result = " + result);
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
        logger.info("user = " + user);
    }
}