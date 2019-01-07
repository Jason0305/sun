package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.User;
import com.lonton.petstore.services.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 启动ioc容器,此处注解作用相当于如下:
 * AbstractApplicationContext ioc = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
 * 下文中@Autowired作用相当于
 * UserMapper userMapper = ioc.getBean("userMapper", UserMapper.class);
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class UserMapperTest {

    /**
     * 自动装配UserMapper
     */
    @Autowired
    private UserMapper userMapper;
    /**
     * log4j实例对象
     */
    private Logger logger;

    /**
     * 单元测试前实例的log4j对象
     */
    @Before
    public void setUp() {
        logger = Logger.getLogger(UserServiceImpl.class);
    }

    /**
     * 测试插入数据到t_user表中
     */
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("Jerry4");
        user.setPassword("123");
        user.setGender(1);
        logger.info(userMapper.insert(user));
    }

    /**
     * 测试通过用户名查询用户数据
     */
    @Test
    public void getUserByUsername() {
        User user = userMapper.getUserByUsername("Jerry");
        logger.info("user = " + user);
    }

    /**
     * 测试通过通过用户ID查询用户数据
     */
    @Test
    public void getUserById() {
        User user = userMapper.getUserById(1);
        logger.info("user = " + user);
    }
}