package com.lonton.petstore.controller;

import com.lonton.petstore.services.IUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

public class UserControllerTest {
    
    @Resource
    private IUserService commentService;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void registerAction() {
    
    }
    
    @Test
    public void loginAction() {
    
    }
}