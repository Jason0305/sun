package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.District;
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
public class DistrictMapperTest {
    @Autowired
    private DistrictMapper districtMapper;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void selectDistrictByCode() {
        String code = "120100";
        List<District> districts = districtMapper.selectDistrictByParent(code);
        log.error("districts = " + districts);
    }
}