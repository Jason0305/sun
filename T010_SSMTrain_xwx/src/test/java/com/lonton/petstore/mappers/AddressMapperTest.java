package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.Address;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.FileNotFoundException;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring/spring-*.xml"})
@WebAppConfiguration("src/main/resources")
public class AddressMapperTest {
    private static AddressMapper mapper;
    @Autowired
    private AddressMapper addressMapper;
    
    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(AddressMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/AddressMapperTestConfiguration.xml"));
        //you can use builder.openSession(true) to commit to database
        mapper = builder.getConfiguration().getMapper(AddressMapper.class, builder.openSession());
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void selectByPrimaryKey() {
        Address address = addressMapper.selectByPrimaryKey(2);
        log.info("address = " + address);
        
    }
    
    @Test
    public void selectLatestAddress() {
    
    }
    
    @Test
    public void countAddressByUid() {
        int count = addressMapper.countAddressByUid(23);
        log.info("count = " + count);
    }
    
    @Test
    public void selectAddressByUid() throws FileNotFoundException {
        log.warn(addressMapper.selectAddressByUid(13));
    }
}