package com.lonton.petstore.services.impl;

import com.lonton.petstore.entity.User;
import com.lonton.petstore.mappers.UserMapper;
import com.lonton.petstore.services.IUserService;
import com.lonton.petstore.services.exceptions.DataInsertException;
import com.lonton.petstore.services.exceptions.PasswordNotMatchException;
import com.lonton.petstore.services.exceptions.UserNotFoundException;
import com.lonton.petstore.services.exceptions.UsernameConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * 用户业务层实现类
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public User register(User user) throws UsernameConflictException, DataInsertException {
        // -判断尝试注册的用户名是否存在
        if (getUserByUsername(user.getUsername()) != null) {
            // --存在，抛出用户已存在异常
            throw new UsernameConflictException("您尝试注册的用户名（" + user.getUsername() + "）已存在!");
        } else {
            // --不存在，将用户数据插入数据库
            insert(user);
            user.setPassword(null);
            return user;
        }
    }
    
    private void insert(User user) {
        user.setSalt(getRandomSalt());
        user.setStatus(1);
        user.setPassword(getEncryptedPassword(user.getPassword(), user.getSalt()));
        if (userMapper.insert(user) == 0) {
            throw new DataInsertException("发生未知错误，请联系系统管理员！");
        }
    }
    
    private String getRandomSalt() {
        return UUID.randomUUID().toString().toUpperCase();
    }
    
    /**
     * 根据用户给定的用户名和密码进行登录验证
     *
     * @param username 用户名
     * @param password 登录密码
     * @return 封装用户信息的实例
     * @throws UserNotFoundException     用户不存在异常
     * @throws PasswordNotMatchException 密码错误异常
     */
    @Override
    public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
        // 根据用户名查询用户信息
        User user = getUserByUsername(username);
        // -根据该用户名判断是否存在该用户
        if (user == null) {
            // --用户名不存抛出用户名不存在异常
            throw new UserNotFoundException("尝试登录的用户名（" + username + "）不存在");
        } else {
            // --用户名存在
            // 获得用户的盐值，根据MD5算法算数出加密后的密文
            String md5Password = getEncryptedPassword(password, user.getSalt());
            //比较密文密码是否一致
            if (md5Password.equals(user.getPassword())) {
                // 一致，保证安全奖盐值和密码密文清除
                user.setPassword(null);
                user.setSalt(null);
                return user;
            } else {
                // 不一致，抛出密不匹配异常
                throw new PasswordNotMatchException("密码错误！");
            }
        }
    }
    
    private String getEncryptedPassword(String password, String salt) {
        // 将加密后的原密码和加密后的盐值拼接然后再加密
        String result = md5(md5(password) + md5(salt));
        // 将上述密文加密5次
        for (int i = 0; i < 6; i++) {
            result = md5(result);
        }
        // 返回最终密文
        return result;
    }
    
    private String md5(String s) {
        return DigestUtils.md5DigestAsHex(s.getBytes()).toUpperCase();
    }
    
    private User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
    
    
}
