package com.lonton.petstore.mappers;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lonton.petstore.entity.Address;

public class AddressSqlProvider {

    public String insertSelective(Address record) {
        BEGIN();
        INSERT_INTO("t_address");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            VALUES("uid", "#{uid,jdbcType=INTEGER}");
        }
        
        if (record.getRecvName() != null) {
            VALUES("recv_name", "#{recvName,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvProvince() != null) {
            VALUES("recv_province", "#{recvProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvCity() != null) {
            VALUES("recv_city", "#{recvCity,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvArea() != null) {
            VALUES("recv_area", "#{recvArea,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvAddress() != null) {
            VALUES("recv_address", "#{recvAddress,jdbcType=CHAR}");
        }
        
        if (record.getRecvPhone() != null) {
            VALUES("recv_phone", "#{recvPhone,jdbcType=CHAR}");
        }
        
        if (record.getRecvTel() != null) {
            VALUES("recv_tel", "#{recvTel,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvZipCode() != null) {
            VALUES("recv_zip_code", "#{recvZipCode,jdbcType=CHAR}");
        }
        
        if (record.getRecvTag() != null) {
            VALUES("recv_tag", "#{recvTag,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDefault() != null) {
            VALUES("is_default", "#{isDefault,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Address record) {
        BEGIN();
        UPDATE("t_address");
        
        if (record.getUid() != null) {
            SET("uid = #{uid,jdbcType=INTEGER}");
        }
        
        if (record.getRecvName() != null) {
            SET("recv_name = #{recvName,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvProvince() != null) {
            SET("recv_province = #{recvProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvCity() != null) {
            SET("recv_city = #{recvCity,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvArea() != null) {
            SET("recv_area = #{recvArea,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvAddress() != null) {
            SET("recv_address = #{recvAddress,jdbcType=CHAR}");
        }
        
        if (record.getRecvPhone() != null) {
            SET("recv_phone = #{recvPhone,jdbcType=CHAR}");
        }
        
        if (record.getRecvTel() != null) {
            SET("recv_tel = #{recvTel,jdbcType=VARCHAR}");
        }
        
        if (record.getRecvZipCode() != null) {
            SET("recv_zip_code = #{recvZipCode,jdbcType=CHAR}");
        }
        
        if (record.getRecvTag() != null) {
            SET("recv_tag = #{recvTag,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDefault() != null) {
            SET("is_default = #{isDefault,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}