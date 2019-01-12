package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.Pets;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PetsMapper {
    @Delete({
        "delete from t_pets",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_pets (id, category, ",
        "name, age, color, ",
        "variety, price, ",
        "image, num, status, ",
        "priority, created_user, ",
        "created_time)",
        "values (#{id,jdbcType=INTEGER}, #{category,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{age,jdbcType=TIMESTAMP}, #{color,jdbcType=VARCHAR}, ",
        "#{variety,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, ",
        "#{image,jdbcType=VARCHAR}, #{num,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{priority,jdbcType=INTEGER}, #{createdUser,jdbcType=INTEGER}, ",
        "#{createdTime,jdbcType=TIMESTAMP})"
    })
    int insert(Pets record);

    @InsertProvider(type=PetsSqlProvider.class, method="insertSelective")
    int insertSelective(Pets record);

    @Select({
        "select",
        "id, category, name, age, color, variety, price, image, num, status, priority, ",
        "created_user, created_time",
        "from t_pets",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="category", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="age", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
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
    Pets selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PetsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Pets record);

    @Update({
        "update t_pets",
        "set category = #{category,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=TIMESTAMP},",
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
    int updateByPrimaryKey(Pets record);
}