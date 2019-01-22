package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.Address;
import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring/spring-*.xml"})
@WebAppConfiguration("src/main/resources")
public class AddressMapperTest {
    @Autowired
    private AddressMapper addressMapper;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void selectByPrimaryKey() {
        Address address = addressMapper.selectByPrimaryKey(2);
        log.info("address = "+address);
        
    }
    
    @Test
    public void selectLatestAddress(){
    
    }
    
    @Test
    public void countAddressByUid() {
        int count = addressMapper.countAddressByUid(1);
        log.info("count = " + count);
    }
}