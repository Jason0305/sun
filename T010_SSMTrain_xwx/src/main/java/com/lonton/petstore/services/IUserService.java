package com.lonton.petstore.services;

import com.lonton.petstore.entity.User;
import com.lonton.petstore.services.exceptions.DataInsertException;
import com.lonton.petstore.services.exceptions.PasswordNotMatchException;
import com.lonton.petstore.services.exceptions.UserNotFoundException;
import com.lonton.petstore.services.exceptions.UsernameConflictException;

/**
 * User业务层接口。
 */
public interface IUserService {
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 登录密码
     * @return 封装用户信息的实例
     * @throws UserNotFoundException     用户名不存在
     * @throws PasswordNotMatchException 密码错误
     */
    User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException;

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 成功注册的数据
     * @throws UsernameConflictException 用户名被占用
     * @throws DataInsertException       位置错误
     */
    User register(User user) throws UsernameConflictException, DataInsertException;
    
    User getUserByUsername(String username);
}
