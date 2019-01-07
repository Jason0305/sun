package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.User;

/**
 * 数据库用户表操作交互接口。
 * @author xuwanxing
 */
//@Mapper
public interface UserMapper {

    int insert(User user);

    /**
     * 通过给定用户名查询用户详细信息
     * @param username 用户名
     * @return 封装了用户信息的实例
     */
    User getUserByUsername(String username);

    /**
     * 通过给定用户ID查询用户详细信息
     * @param id 用户ID
     * @return 封装了用户信息的实例
     */
    User getUserById(int id);

}
