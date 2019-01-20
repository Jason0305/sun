package com.lonton.petstore.mappers;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lonton.petstore.entity.OrderItem;

public class OrderItemSqlProvider {

    public String insertSelective(OrderItem record) {
        BEGIN();
        INSERT_INTO("t_order_item");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getOrderId() != null) {
            VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getPetId() != null) {
            VALUES("pet_id", "#{petId,jdbcType=INTEGER}");
        }
        
        if (record.getPetName() != null) {
            VALUES("pet_name", "#{petName,jdbcType=VARCHAR}");
        }
        
        if (record.getPetAge() != null) {
            VALUES("pet_age", "#{petAge,jdbcType=INTEGER}");
        }
        
        if (record.getPetColor() != null) {
            VALUES("pet_color", "#{petColor,jdbcType=VARCHAR}");
        }
        
        if (record.getPetPrice() != null) {
            VALUES("pet_price", "#{petPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPetImage() != null) {
            VALUES("pet_image", "#{petImage,jdbcType=VARCHAR}");
        }
        
        if (record.getPetNum() != null) {
            VALUES("pet_num", "#{petNum,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderItem record) {
        BEGIN();
        UPDATE("t_order_item");
        
        if (record.getOrderId() != null) {
            SET("order_id = #{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getPetId() != null) {
            SET("pet_id = #{petId,jdbcType=INTEGER}");
        }
        
        if (record.getPetName() != null) {
            SET("pet_name = #{petName,jdbcType=VARCHAR}");
        }
        
        if (record.getPetAge() != null) {
            SET("pet_age = #{petAge,jdbcType=INTEGER}");
        }
        
        if (record.getPetColor() != null) {
            SET("pet_color = #{petColor,jdbcType=VARCHAR}");
        }
        
        if (record.getPetPrice() != null) {
            SET("pet_price = #{petPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPetImage() != null) {
            SET("pet_image = #{petImage,jdbcType=VARCHAR}");
        }
        
        if (record.getPetNum() != null) {
            SET("pet_num = #{petNum,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}