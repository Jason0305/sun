package com.lonton.petstore.services.impl;

import com.lonton.petstore.entity.District;
import com.lonton.petstore.services.IDistrictService;
import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring/spring-*.xml"})
@WebAppConfiguration("src/main/resources")
public class DistrictServiceImplTest {
    @Autowired
    private IDistrictService districtService;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void listChild() {
        String parent = "120100";
        List<District> districts = districtService.getDistricts(parent);
        log.error("districts = " + districts);
    }
}