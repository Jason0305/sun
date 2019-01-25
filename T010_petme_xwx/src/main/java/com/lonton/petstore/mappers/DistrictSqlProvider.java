package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.District;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class DistrictSqlProvider {

    public String insertSelective(District record) {
        BEGIN();
        INSERT_INTO("t_district");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getParent() != null) {
            VALUES("parent", "#{parent,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(District record) {
        BEGIN();
        UPDATE("t_district");
        
        if (record.getParent() != null) {
            SET("parent = #{parent,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}