package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.OrderItem;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderItemMapper {
    @Delete({
        "delete from t_order_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_order_item (id, order_id, ",
        "pet_id, pet_name, ",
        "pet_age, pet_color, ",
        "pet_price, pet_image, ",
        "pet_num)",
        "values (#{id,jdbcType=INTEGER}, #{orderId,jdbcType=INTEGER}, ",
        "#{petId,jdbcType=INTEGER}, #{petName,jdbcType=VARCHAR}, ",
        "#{petAge,jdbcType=INTEGER}, #{petColor,jdbcType=VARCHAR}, ",
        "#{petPrice,jdbcType=DECIMAL}, #{petImage,jdbcType=VARCHAR}, ",
        "#{petNum,jdbcType=INTEGER})"
    })
    int insert(OrderItem record);

    @InsertProvider(type=OrderItemSqlProvider.class, method="insertSelective")
    int insertSelective(OrderItem record);

    @Select({
        "select",
        "id, order_id, pet_id, pet_name, pet_age, pet_color, pet_price, pet_image, pet_num",
        "from t_order_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="order_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="pet_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="pet_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="pet_age", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="pet_color", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="pet_price", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="pet_image", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="pet_num", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    OrderItem selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrderItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderItem record);

    @Update({
        "update t_order_item",
        "set order_id = #{orderId,jdbcType=INTEGER},",
          "pet_id = #{petId,jdbcType=INTEGER},",
          "pet_name = #{petName,jdbcType=VARCHAR},",
          "pet_age = #{petAge,jdbcType=INTEGER},",
          "pet_color = #{petColor,jdbcType=VARCHAR},",
          "pet_price = #{petPrice,jdbcType=DECIMAL},",
          "pet_image = #{petImage,jdbcType=VARCHAR},",
          "pet_num = #{petNum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderItem record);
}