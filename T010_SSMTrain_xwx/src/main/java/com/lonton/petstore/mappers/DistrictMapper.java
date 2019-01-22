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

import java.util.List;

public interface DistrictMapper {
    @Delete({"delete from t_district where id = #{id,jdbcType=INTEGER}"})
    int deleteByPrimaryKey(Integer id);
    
    @Insert({"insert into t_district (id, parent, `code`, `name`)",
            "values (#{id,jdbcType=INTEGER}, #{parent,jdbcType=VARCHAR}, ",
            "#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"})
    int insert(District record);
    
    @InsertProvider(type = DistrictSqlProvider.class, method = "insertSelective")
    int insertSelective(District record);
    
    @Select({"select ",
            "id, parent, `code`, name",
            "from t_district ",
            "where id = #{id,jdbcType=INTEGER}"})
    @ConstructorArgs({@Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "parent", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    District selectByPrimaryKey(Integer id);
    
    @Select({"select ",
            "id, parent, code, name",
            "from t_district ",
            "where code = #{code,jdbcType=VARCHAR}"})
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "parent", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    District selectByCode(String code);
    
    @UpdateProvider(type = DistrictSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(District record);
    
    @Update({"update t_district ",
            "set parent = #{parent,jdbcType=VARCHAR},",
            "`code` = #{code,jdbcType=VARCHAR},",
            "`name` = #{name,jdbcType=VARCHAR} ",
            "where id = #{id,jdbcType=INTEGER}"})
    int updateByPrimaryKey(District record);
    
    @Select({"SELECT id, parent, `code`, `name` FROM `t_district` WHERE `code` NOT LIKE '___000' order by rand() limit 1"})
    District selectRandomArea();
    
    @Select({"select id, parent, `code`, `name` from t_district where parent = #{code,jdbcType=VARCHAR}"})
    List<District> selectDistrictByParent(String parent);
}