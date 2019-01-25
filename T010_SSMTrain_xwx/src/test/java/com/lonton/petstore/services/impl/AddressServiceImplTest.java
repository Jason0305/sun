package com.lonton.petstore.services.impl;

import com.lonton.petstore.entity.Address;
import com.lonton.petstore.services.IAddressService;
import com.lonton.petstore.services.exceptions.AddressNotExistsException;
import com.lonton.petstore.services.exceptions.ArgumentException;
import com.lonton.petstore.services.exceptions.UpdateDataException;
import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
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
    public void getAddressList() {
        List<Address> addresses = null;
        try {
            addresses = addressService.getAddressList(20);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("e.message=" + e.getMessage());
        }
        log.error("addresses = " + addresses);
    }
    
    @Test
    public void addAddress() {
        Address address = new Address();
        address.setRecvProvince("123123");
        address.setRecvArea("123123");
        address.setRecvCity("123123");
        address.setUid(123123);
        address.setRecvAddress("354545sadf");
        address.setIsDefault(1);
        address.setCreatedTime(new Date());
        addressService.addAddress(address);
        
    }
    
    @Test
    public void deleteAddress() {
        try {
            List<Address> addresses = addressService.getAddressList(20);
            log.warn("删除前用地址为:" + addresses);
            addressService.deleteAddress(20,2772);
        } catch (AddressNotExistsException e) {
            e.printStackTrace();
        } catch (UpdateDataException e) {
            e.printStackTrace();
        } catch (ArgumentException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void updateAddress() {
    }
    
    @Test
    public void getAddressById() {
    }
    
}