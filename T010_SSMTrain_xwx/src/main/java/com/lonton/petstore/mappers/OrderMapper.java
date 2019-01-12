package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.Order;
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

public interface OrderMapper {
    @Delete({
        "delete from t_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_order (id, uid, ",
        "recv_name, recv_phone, ",
        "recv_address, total_price, ",
        "status, created_time, ",
        "pay_time)",
        "values (#{id,jdbcType=INTEGER}, #{uid,jdbcType=INTEGER}, ",
        "#{recvName,jdbcType=VARCHAR}, #{recvPhone,jdbcType=VARCHAR}, ",
        "#{recvAddress,jdbcType=VARCHAR}, #{totalPrice,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=INTEGER}, #{createdTime,jdbcType=TIMESTAMP}, ",
        "#{payTime,jdbcType=TIMESTAMP})"
    })
    int insert(Order record);

    @InsertProvider(type=OrderSqlProvider.class, method="insertSelective")
    int insertSelective(Order record);

    @Select({
        "select",
        "id, uid, recv_name, recv_phone, recv_address, total_price, status, created_time, ",
        "pay_time",
        "from t_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="uid", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="recv_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="recv_phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="recv_address", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="total_price", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="status", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="created_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="pay_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Order selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update t_order",
        "set uid = #{uid,jdbcType=INTEGER},",
          "recv_name = #{recvName,jdbcType=VARCHAR},",
          "recv_phone = #{recvPhone,jdbcType=VARCHAR},",
          "recv_address = #{recvAddress,jdbcType=VARCHAR},",
          "total_price = #{totalPrice,jdbcType=DECIMAL},",
          "status = #{status,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}