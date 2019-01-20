package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.ShopCart;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ShopCartMapper {
    @Delete({
        "delete from t_shop_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_shop_cart (id, uid, ",
        "pet_id, pet_num)",
        "values (#{id,jdbcType=INTEGER}, #{uid,jdbcType=INTEGER}, ",
        "#{petId,jdbcType=INTEGER}, #{petNum,jdbcType=INTEGER})"
    })
    int insert(ShopCart record);

    @InsertProvider(type=ShopCartSqlProvider.class, method="insertSelective")
    int insertSelective(ShopCart record);

    @Select({
        "select",
        "id, uid, pet_id, pet_num",
        "from t_shop_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="uid", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="pet_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="pet_num", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    ShopCart selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ShopCartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopCart record);

    @Update({
        "update t_shop_cart",
        "set uid = #{uid,jdbcType=INTEGER},",
          "pet_id = #{petId,jdbcType=INTEGER},",
          "pet_num = #{petNum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShopCart record);
}