package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.Cart;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CartMapper {
    @Delete({
        "delete from t_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_cart (id, uid, ",
        "pet_id, pet_num)",
        "values (#{id,jdbcType=INTEGER}, #{uid,jdbcType=INTEGER}, ",
        "#{petId,jdbcType=BIGINT}, #{petNum,jdbcType=INTEGER})"
    })
    int insert(Cart record);

    @InsertProvider(type=CartSqlProvider.class, method="insertSelective")
    int insertSelective(Cart record);

    @Select({
        "select",
        "id, uid, pet_id, pet_num",
        "from t_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="uid", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="pet_id", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="pet_num", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    Cart selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Cart record);

    @Update({
        "update t_cart",
        "set uid = #{uid,jdbcType=INTEGER},",
          "pet_id = #{petId,jdbcType=BIGINT},",
          "pet_num = #{petNum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Cart record);
}