package com.lonton.petstore.generator;

import com.lonton.petstore.entity.Address;
import com.lonton.petstore.entity.Order;
import com.lonton.petstore.mappers.AddressMapper;
import com.lonton.petstore.mappers.OrderMapper;
import com.lonton.petstore.mappers.UserMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:Spring/spring-*.xml"})
public class OrderInsertTest {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    
    @Test
    public void orderInsert() {
        int uid = 0;
        Order order = new Order();
        int i = 0;
        for (; i < 10000; i++) {
//            try {
                uid = (int) (Math.random() * 10000 + 1);
//                log.warn(uid);
                order.setUid(uid);
                Address address = addressMapper.getAddressByUid(uid);
                if(address == null){
                    i--;
                    continue;
                }
                order.setRecvName(userMapper.selectByPrimaryKey(uid).getUsername());
                order.setRecvPhone(address.getRecvPhone());
                order.setRecvAddress(address.getRecvAddress());
                order.setTotal(BigDecimal.valueOf(Math.random() * 10000));
                order.setStatus((int) (Math.random() * 4));
                order.setCreatedTime(new Date());
                order.setPayTime(new Date());
                orderMapper.insertSelective(order);
                
//            } catch (Exception e) {
////                log.error(e.getMessage());
////                log.warn(uid);
//                i--;
//            }
        }
    }
    
    @Test
    public void test() {
        log.warn(addressMapper.getAddressByUid(5652));
    }
    
}
