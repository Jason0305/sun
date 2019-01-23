package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

public interface UserMapper {
    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_user (id, username, ",
        "password, gender, email, ",
        "phone, avatar, salt, ",
        "grade, status, last_login, ",
        "created_time)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=CHAR}, #{gender,jdbcType=INTEGER}, #{email,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=CHAR}, #{avatar,jdbcType=VARCHAR}, #{salt,jdbcType=CHAR}, ",
        "#{grade,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{lastLogin,jdbcType=TIMESTAMP}, ",
        "#{createdTime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "id, username, password, gender, email, phone, avatar, salt, grade, status, last_login, ",
        "created_time",
        "from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="username", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="gender", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="avatar", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="salt", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="grade", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="status", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="last_login", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update t_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=CHAR},",
          "gender = #{gender,jdbcType=INTEGER},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=CHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=CHAR},",
          "grade = #{grade,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "last_login = #{lastLogin,jdbcType=TIMESTAMP},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
    
    @Select({"SELECT *",
            "FROM t_user",
            "WHERE username = #{username}"})
    User getUserByUsername(String username);
}