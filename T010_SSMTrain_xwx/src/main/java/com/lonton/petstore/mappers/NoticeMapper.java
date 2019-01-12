package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.Notice;
import java.util.Date;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface NoticeMapper {
    @Delete({
        "delete from t_notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_notice (id, title, ",
        "created_user, created_time, ",
        "content)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{createdUser,jdbcType=INTEGER}, #{createdTime,jdbcType=TIMESTAMP}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Notice record);

    @InsertProvider(type=NoticeSqlProvider.class, method="insertSelective")
    int insertSelective(Notice record);

    @Select({
        "select",
        "id, title, created_user, created_time, content",
        "from t_notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="title", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="created_user", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="created_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="content", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    Notice selectByPrimaryKey(Integer id);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Notice record);

    @Update({
        "update t_notice",
        "set title = #{title,jdbcType=VARCHAR},",
          "created_user = #{createdUser,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Notice record);

    @Update({
        "update t_notice",
        "set title = #{title,jdbcType=VARCHAR},",
          "created_user = #{createdUser,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Notice record);
}