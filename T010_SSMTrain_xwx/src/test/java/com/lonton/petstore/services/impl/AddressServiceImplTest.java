package com.lonton.petstore.services.impl;

import com.lonton.petstore.entity.Address;
import com.lonton.petstore.services.IAddressService;
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
public class AddressServiceImplTest {
    @Autowired
    private IAddressService addressService;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void getAddresses() {
        List<Address> addresses = addressService.getAddresses(13);
        log.error("addresses = " + addresses);
    }
    
    @Test
    public void addNew() {
    }
    
    @Test
    public void addAddress() {
    
    }
    
    @Test
    public void deleteAddress() {
    }
    
    @Test
    public void updateAddress() {
    }
    
    @Test
    public void getAddressById() {
    }
    
    @Test
    public void getAddresses1() {
    }
}