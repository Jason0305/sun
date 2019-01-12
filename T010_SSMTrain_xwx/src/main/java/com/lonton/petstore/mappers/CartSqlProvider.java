package com.lonton.petstore.mappers;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lonton.petstore.entity.Cart;

public class CartSqlProvider {

    public String insertSelective(Cart record) {
        BEGIN();
        INSERT_INTO("t_cart");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            VALUES("uid", "#{uid,jdbcType=INTEGER}");
        }
        
        if (record.getPetId() != null) {
            VALUES("pet_id", "#{petId,jdbcType=BIGINT}");
        }
        
        if (record.getPetNum() != null) {
            VALUES("pet_num", "#{petNum,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Cart record) {
        BEGIN();
        UPDATE("t_cart");
        
        if (record.getUid() != null) {
            SET("uid = #{uid,jdbcType=INTEGER}");
        }
        
        if (record.getPetId() != null) {
            SET("pet_id = #{petId,jdbcType=BIGINT}");
        }
        
        if (record.getPetNum() != null) {
            SET("pet_num = #{petNum,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}