package com.lonton.petstore.mappers;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lonton.petstore.entity.Order;

public class OrderSqlProvider {

    public String insertSelective(Order record) {
        BEGIN();
        INSERT_INTO("t_order");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            VALUES("uid", "#{uid,jdbcType=INTEGER}");
        }
        
        if (record.getRecvName() != null) {
            VALUES("recv_name", "#{recvName,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvPhone() != null) {
            VALUES("recv_phone", "#{recvPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvAddress() != null) {
            VALUES("recv_address", "#{recvAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalPrice() != null) {
            VALUES("total_price", "#{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayTime() != null) {
            VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Order record) {
        BEGIN();
        UPDATE("t_order");
        
        if (record.getUid() != null) {
            SET("uid = #{uid,jdbcType=INTEGER}");
        }
        
        if (record.getRecvName() != null) {
            SET("recv_name = #{recvName,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvPhone() != null) {
            SET("recv_phone = #{recvPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvAddress() != null) {
            SET("recv_address = #{recvAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalPrice() != null) {
            SET("total_price = #{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayTime() != null) {
            SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}