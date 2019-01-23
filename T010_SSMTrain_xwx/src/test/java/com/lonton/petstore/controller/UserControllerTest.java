package com.lonton.petstore.controller;

import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Log4j
public class UserControllerTest {
    
    //    @Resource
    //    private IUserService commentService;
    //
    //    @Autowired
    //    private WebApplicationContext webApplicationContext;
    
    
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
        //        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void registerAction() {
    
    }
    
    @Test
    public void loginAction() {
        StringBuilder sb = new StringBuilder("0123.45");
        
        sb.insert(sb.lastIndexOf("."), UUID.randomUUID()).insert(0, new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss_[").format(new Date()));
        log.warn(sb);
    }
}