package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.ShopCart;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ShopCartSqlProvider {

    public String insertSelective(ShopCart record) {
        BEGIN();
        INSERT_INTO("t_shop_cart");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            VALUES("uid", "#{uid,jdbcType=INTEGER}");
        }
        
        if (record.getPetId() != null) {
            VALUES("pet_id", "#{petId,jdbcType=INTEGER}");
        }
        
        if (record.getPetNum() != null) {
            VALUES("pet_num", "#{petNum,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ShopCart record) {
        BEGIN();
        UPDATE("t_shop_cart");
        
        if (record.getUid() != null) {
            SET("uid = #{uid,jdbcType=INTEGER}");
        }
        
        if (record.getPetId() != null) {
            SET("pet_id = #{petId,jdbcType=INTEGER}");
        }
        
        if (record.getPetNum() != null) {
            SET("pet_num = #{petNum,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}