package com.lonton.petstore.generator;


import com.lonton.petstore.generator.entity.*;
import com.lonton.petstore.mappers.mapper.*;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class GeneratorDataTest {
    @Autowired
    private CartMapper        cartMapper;
    private Cart              cart;
    @Autowired
    private DistrictMapper    districtMapper;
    private District          district;
    @Autowired
    private NoticeMapper      noticeMapper;
    private Notice            notice;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    private OrderDetail oderDetail;
    @Autowired
    private OrderMapper       orderMapper;
    private Order             order;
    @Autowired
    private PersonMapper      personMapper;
    private Person            person;
    @Autowired
    private PetsMapper        petsMapper;
    private Pets              pets;
    
    
    @Test
    public void personInsert() {
        person = new Person();
        personMapper.insert(person);
    }
    
    
    
    
}
