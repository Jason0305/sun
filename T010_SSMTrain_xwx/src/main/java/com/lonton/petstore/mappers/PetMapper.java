package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.Pet;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.util.Date;

public interface PetMapper {
    @Delete({
        "delete from t_pets",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_pets (id, name, ",
        "family, size, fn_feature, ",
        "advantages, birth, ",
        "love, color, variety, ",
        "price, image, num, ",
        "status, priority, ",
        "created_user, created_time)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{family,jdbcType=VARCHAR}, #{size,jdbcType=CHAR}, #{fnFeature,jdbcType=VARCHAR}, ",
        "#{advantages,jdbcType=CHAR}, #{birth,jdbcType=TIMESTAMP}, ",
        "#{love,jdbcType=INTEGER}, #{color,jdbcType=VARCHAR}, #{variety,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=DECIMAL}, #{image,jdbcType=VARCHAR}, #{num,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{priority,jdbcType=INTEGER}, ",
        "#{createdUser,jdbcType=INTEGER}, #{createdTime,jdbcType=TIMESTAMP})"
    })
    int insert(Pet record);

    @InsertProvider(type=PetSqlProvider.class, method="insertSelective")
    int insertSelective(Pet record);

    @Select({
        "select",
        "id, name, family, size, fn_feature, advantages, birth, love, color, variety, ",
        "price, image, num, status, priority, created_user, created_time",
        "from t_pets",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="family", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="size", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="fn_feature", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="advantages", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="birth", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="love", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="color", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="variety", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="price", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="image", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="num", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="status", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="priority", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="created_user", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="created_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Pet selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PetSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Pet record);

    @Update({
        "update t_pets",
        "set name = #{name,jdbcType=VARCHAR},",
          "family = #{family,jdbcType=VARCHAR},",
          "size = #{size,jdbcType=CHAR},",
          "fn_feature = #{fnFeature,jdbcType=VARCHAR},",
          "advantages = #{advantages,jdbcType=CHAR},",
          "birth = #{birth,jdbcType=TIMESTAMP},",
          "love = #{love,jdbcType=INTEGER},",
          "color = #{color,jdbcType=VARCHAR},",
          "variety = #{variety,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "image = #{image,jdbcType=VARCHAR},",
          "num = #{num,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "priority = #{priority,jdbcType=INTEGER},",
          "created_user = #{createdUser,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Pet record);
    
    @Select({
            "select",
            "id, name, family, size, fn_feature, advantages, birth, love, color, variety, ",
            "price, image, num, status, priority, created_user, created_time",
            "from t_pets",
            "order by rand() limit 1"
    })
    @ConstructorArgs({
            @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
            @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="family", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="size", javaType=String.class, jdbcType=JdbcType.CHAR),
            @Arg(column="fn_feature", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="advantages", javaType=String.class, jdbcType=JdbcType.CHAR),
            @Arg(column="birth", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="love", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="color", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="variety", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="price", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="image", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="num", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="status", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="priority", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="created_user", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="created_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Pet findPetRandom();
}