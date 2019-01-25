package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.Notice;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class NoticeSqlProvider {

    public String insertSelective(Notice record) {
        BEGIN();
        INSERT_INTO("t_notice");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedUser() != null) {
            VALUES("created_user", "#{createdUser,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Notice record) {
        BEGIN();
        UPDATE("t_notice");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedUser() != null) {
            SET("created_user = #{createdUser,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}