package com.lonton.petstore.mappers;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lonton.petstore.entity.Pet;

public class PetSqlProvider {

    public String insertSelective(Pet record) {
        BEGIN();
        INSERT_INTO("t_pets");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getFamily() != null) {
            VALUES("family", "#{family,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            VALUES("size", "#{size,jdbcType=CHAR}");
        }
        
        if (record.getFnFeature() != null) {
            VALUES("fn_feature", "#{fnFeature,jdbcType=VARCHAR}");
        }
        
        if (record.getAdvantages() != null) {
            VALUES("advantages", "#{advantages,jdbcType=CHAR}");
        }
        
        if (record.getBirth() != null) {
            VALUES("birth", "#{birth,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLove() != null) {
            VALUES("love", "#{love,jdbcType=INTEGER}");
        }
        
        if (record.getColor() != null) {
            VALUES("color", "#{color,jdbcType=VARCHAR}");
        }
        
        if (record.getVariety() != null) {
            VALUES("variety", "#{variety,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getImage() != null) {
            VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            VALUES("num", "#{num,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPriority() != null) {
            VALUES("priority", "#{priority,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedUser() != null) {
            VALUES("created_user", "#{createdUser,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Pet record) {
        BEGIN();
        UPDATE("t_pets");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getFamily() != null) {
            SET("family = #{family,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            SET("size = #{size,jdbcType=CHAR}");
        }
        
        if (record.getFnFeature() != null) {
            SET("fn_feature = #{fnFeature,jdbcType=VARCHAR}");
        }
        
        if (record.getAdvantages() != null) {
            SET("advantages = #{advantages,jdbcType=CHAR}");
        }
        
        if (record.getBirth() != null) {
            SET("birth = #{birth,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLove() != null) {
            SET("love = #{love,jdbcType=INTEGER}");
        }
        
        if (record.getColor() != null) {
            SET("color = #{color,jdbcType=VARCHAR}");
        }
        
        if (record.getVariety() != null) {
            SET("variety = #{variety,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getImage() != null) {
            SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            SET("num = #{num,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPriority() != null) {
            SET("priority = #{priority,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedUser() != null) {
            SET("created_user = #{createdUser,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}