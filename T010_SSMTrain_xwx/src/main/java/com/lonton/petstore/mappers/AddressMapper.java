package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.Address;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AddressMapper {
    @Delete({
        "delete from t_address",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_address (id, uid, ",
        "recv_name, recv_province, ",
        "recv_city, recv_area, ",
        "recv_address, recv_phone, ",
        "recv_tel, recv_zip_code, ",
        "recv_tag, is_default, ",
        "created_time)",
        "values (#{id,jdbcType=INTEGER}, #{uid,jdbcType=INTEGER}, ",
        "#{recvName,jdbcType=VARCHAR}, #{recvProvince,jdbcType=VARCHAR}, ",
        "#{recvCity,jdbcType=VARCHAR}, #{recvArea,jdbcType=VARCHAR}, ",
        "#{recvAddress,jdbcType=CHAR}, #{recvPhone,jdbcType=CHAR}, ",
        "#{recvTel,jdbcType=VARCHAR}, #{recvZipCode,jdbcType=CHAR}, ",
        "#{recvTag,jdbcType=VARCHAR}, #{isDefault,jdbcType=INTEGER}, ",
        "#{createdTime,jdbcType=TIMESTAMP})"
    })
    int insert(Address record);

    @InsertProvider(type=AddressSqlProvider.class, method="insertSelective")
    int insertSelective(Address record);

    @Select({
        "select",
        "id, uid, recv_name, recv_province, recv_city, recv_area, recv_address, recv_phone, ",
        "recv_tel, recv_zip_code, recv_tag, is_default, created_time",
        "from t_address",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="uid", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="recv_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="recv_province", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="recv_city", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="recv_area", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="recv_address", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="recv_phone", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="recv_tel", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="recv_zip_code", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="recv_tag", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_default", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="created_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Address selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Address record);

    @Update({
        "update t_address",
        "set uid = #{uid,jdbcType=INTEGER},",
          "recv_name = #{recvName,jdbcType=VARCHAR},",
          "recv_province = #{recvProvince,jdbcType=VARCHAR},",
          "recv_city = #{recvCity,jdbcType=VARCHAR},",
          "recv_area = #{recvArea,jdbcType=VARCHAR},",
          "recv_address = #{recvAddress,jdbcType=CHAR},",
          "recv_phone = #{recvPhone,jdbcType=CHAR},",
          "recv_tel = #{recvTel,jdbcType=VARCHAR},",
          "recv_zip_code = #{recvZipCode,jdbcType=CHAR},",
          "recv_tag = #{recvTag,jdbcType=VARCHAR},",
          "is_default = #{isDefault,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Address record);
    @Select({
            "select",
            "id, uid, recv_name, recv_province, recv_city, recv_area, recv_address, recv_phone, ",
            "recv_tel, recv_zip_code, recv_tag, is_default, created_time",
            "from t_address",
            "where uid = #{uid,jdbcType=INTEGER} limit 1"
    })
    @ConstructorArgs({
            @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
            @Arg(column="uid", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="recv_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="recv_province", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="recv_city", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="recv_area", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="recv_address", javaType=String.class, jdbcType=JdbcType.CHAR),
            @Arg(column="recv_phone", javaType=String.class, jdbcType=JdbcType.CHAR),
            @Arg(column="recv_tel", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="recv_zip_code", javaType=String.class, jdbcType=JdbcType.CHAR),
            @Arg(column="recv_tag", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="is_default", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="created_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Address getAddressByUid(Integer uid);
    
}
