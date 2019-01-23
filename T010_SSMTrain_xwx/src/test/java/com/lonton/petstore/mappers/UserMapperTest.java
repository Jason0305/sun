package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.User;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;

/**
 * 启动ioc容器,此处注解作用相当于如下:
 * AbstractApplicationContext ioc = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
 * 下文中@Autowired作用相当于
 * UserMapper userMapper = ioc.getBean("userMapper", UserMapper.class);
 *
 * @author xuwanxing
 */
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:Spring/spring-*.xml"})
public class UserMapperTest {
    
    private static UserMapper mapper;
    /**
     * 自动装配UserMapper
     */
    @Autowired
    private UserMapper userMapper;
    
    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(UserMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/UserMapperTestConfiguration.xml"));
        //you can use builder.openSession(true) to commit to database
        mapper = builder.getConfiguration().getMapper(UserMapper.class, builder.openSession());
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
        log.info(userMapper.insert(user));
    }
    
    /**
     * 测试通过用户名查询用户数据
     */
    @Test
    public void getUserByUsername() {
        User user = userMapper.getUserByUsername("Jerry");
        log.info("user = " + user);
    }
    
    /**
     * 测试通过通过用户ID查询用户数据
     */
    @Test
    public void getUserById() {
        User user = userMapper.selectByPrimaryKey(1);
        log.info("user = " + user);
    }
    
    @Test
    public void testinsert() throws FileNotFoundException {
//        mapper.insert();
    }
}