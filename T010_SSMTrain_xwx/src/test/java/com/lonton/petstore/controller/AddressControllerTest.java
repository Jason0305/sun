package com.lonton.petstore.controller;

import com.lonton.petstore.entity.ResponseResult;
import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring/spring-*.xml"})
@WebAppConfiguration("src/main/resources")
public class AddressControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void listAction() throws Exception {
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("classpath:/address/list.do");
        req.param("uid", "1");
        MvcResult result = mockMvc.perform(req).andReturn();
        MockHttpServletRequest request = result.getRequest();
        ResponseResult<?> rr = (ResponseResult<?>) request.getAttribute("pageInfo");
        System.out.println(rr);
    }
}