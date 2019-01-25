package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.User;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.util.UUID;

/**
 * 用户通能mybatis接口测试用例.
 * <p>
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
    /**
     * 自动装配UserMapper
     */
    @Autowired
    private UserMapper userMapper;
    
    /**
     * 测试通过用户名查询用户数据.
     */
    @Test
    public void getUserByUsername() {
        try {
            User user = userMapper.getUserByUsername("雷云");
            log.info(user);
        } catch (Exception e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
    }
    
    /**
     * 测试通过通过用户ID查询用户数据.
     */
    @Test
    public void getUserById() {
        User user = null;
        try {
            user = userMapper.selectByPrimaryKey(1);
        } catch (Exception e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
        log.info("user = " + user);
    }
    
    /**
     * 选择性插入用户数据.
     */
    @Test
    public void insertSelective() {
        User user = new User();
        final int endIndex = 8;
        user.setUsername(UUID.randomUUID().toString().substring(0, endIndex));
        user.setPassword("you123");
        user.setPhone("13145784568");
        user.setGender(1);
        user.setEmail(UUID.randomUUID().toString().substring(0, endIndex) + "@foxmail.com");
        try {
            userMapper.insertSelective(user);
        } catch (Exception e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
    }
    
    /**
     * 通过用户id删除用户信息.
     */
    @Test
    public void deleteByPrimaryKey() {
        try {
            userMapper.deleteByPrimaryKey(1);
        } catch (Exception e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
    }
    
    @Test
    public void insert() throws FileNotFoundException {
        User user = new User();
        final int endIndex = 8;
        user.setUsername(UUID.randomUUID().toString().substring(0, endIndex));
        user.setPassword("you123");
        user.setPhone("13145784568");
        user.setGender(1);
        user.setEmail(UUID.randomUUID().toString().substring(0, endIndex) + "@foxmail.com");
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
    }
    
    /**
     * 更新用户信息.
     */
    @Test
    public void updateByPrimaryKeySelective() {
        try {
            final int uid = 9;
            log.warn("修改前" + userMapper.selectByPrimaryKey(uid));
            User user = new User();
            user.setId(uid);
            user.setUsername("臧彦晋1");
            user.setPhone("16545487256");
            user.setAvatar("upload/abc.jpg");
            userMapper.updateByPrimaryKeySelective(user);
            log.warn("修改前" + userMapper.selectByPrimaryKey(uid));
        } catch (Exception e) {
            log.warn(e.getStackTrace());
            log.warn("e.message = " + e.getMessage());
        }
    }
}