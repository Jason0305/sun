package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.District;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DistrictMapper {
    @Delete({
        "delete from t_dict_district",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_dict_district (id, parent, ",
        "code, name)",
        "values (#{id,jdbcType=INTEGER}, #{parent,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    int insert(District record);

    @InsertProvider(type=DistrictSqlProvider.class, method="insertSelective")
    int insertSelective(District record);

    @Select({
        "select",
        "id, parent, code, name",
        "from t_dict_district",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="parent", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    District selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DistrictSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(District record);

    @Update({
        "update t_dict_district",
        "set parent = #{parent,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(District record);
}