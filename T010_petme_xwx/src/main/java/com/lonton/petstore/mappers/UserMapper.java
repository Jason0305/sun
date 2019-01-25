package com.lonton.petstore.mappers;

import com.lonton.petstore.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * 用户通能mybatis接口.
 *
 * @author xuwanxing
 */
public interface UserMapper {
    /**
     * 根据id删除用户信息.
     *
     * @param id 用户id
     * @return 执行成功的条数
     */
    @Delete({"delete from t_user ",
            "where id = #{id,jdbcType=INTEGER}"})
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 新增用户信息.
     *
     * @param record 用户信息实例
     * @return 执行成功的条数
     */
    @Insert({"insert into t_user (id , username, ",
            "password, gender, email, ",
            "phone, avatar, salt, ",
            "grade, status, last_login, ",
            "created_time)",
            "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
            "#{password,jdbcType=CHAR}, #{gender,jdbcType=INTEGER}, #{email,jdbcType=VARCHAR}, ",
            "#{phone,jdbcType=CHAR}, #{avatar,jdbcType=VARCHAR}, #{salt,jdbcType=CHAR}, ",
            "#{grade,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{lastLogin,jdbcType=TIMESTAMP}, ",
            "#{createdTime,jdbcType=TIMESTAMP})"})
    int insert(User record);
    
    /**
     * 选择性新增用户信息.
     *
     * @param record 包含用户信息的实例
     * @return 执行成功的条数
     */
    @InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
    int insertSelective(User record);
    
    /**
     * 根据用户id查询用户信息.
     *
     * @param id 用户id
     * @return 用户信息实例
     */
    @Select({"select ",
            "id, username, password, gender, email, phone, avatar, salt, grade, status, last_login lastLogin, ",
            "created_time createdTime ",
            "from t_user ",
            "where id = #{id,jdbcType=INTEGER}"})
    User selectByPrimaryKey(Integer id);
    
    /**
     * 选择性更新用户信息.
     *
     * @param record 包含用户信息的实例
     * @return 执行成功的条数
     */
    @UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);
    
    /**
     * 修改用户指定信息.
     *
     * @param record 包含用户信息的实例
     * @return 执行成功的条数
     */
    @Update({"update t_user ",
            "set username = #{username,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=CHAR},",
            "gender = #{gender,jdbcType=INTEGER},",
            "email = #{email,jdbcType=VARCHAR},",
            "phone = #{phone,jdbcType=CHAR},",
            "avatar = #{avatar,jdbcType=VARCHAR},",
            "salt = #{salt,jdbcType=CHAR},",
            "grade = #{grade,jdbcType=INTEGER},",
            "status = #{status,jdbcType=INTEGER},",
            "last_login = #{lastLogin,jdbcType=TIMESTAMP},",
            "created_time = #{createdTime,jdbcType=TIMESTAMP} ",
            "where id = #{id,jdbcType=INTEGER}"})
    int updateByPrimaryKey(User record);
    
    /**
     * 根据用户名查询用户信息.
     *
     * @param username 用户名
     * @return 包含用户信息的实例
     */
    @Select({"SELECT * ",
            "FROM t_user ",
            "WHERE username = #{username}"})
    User getUserByUsername(String username);
}