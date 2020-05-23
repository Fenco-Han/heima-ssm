package com.itheima.ssm.dao;

import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: hanpengfei
 * @Date: 2020/5/13 21:08
 * heima_ssm
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    public List<UserInfo> findAll() throws Exception;

    /**
     * 保存用户信息
     * @param userInfo
     * @throws Exception
     */
    @Insert("insert into users (email, username, password, phoneNum, status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo) throws Exception;

    /**
     * 查看用户详情信息，包含【用户、角色、权限】
     * 这里直接引用findRoleByUserId,其中包含了权限的sql
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id",javaType = java.util.List.class, many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findById(String id) throws Exception;

    /**
     *给用户添加角色
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into user_role (userId, roleId) values (#{userId}, #{roleId})")
    public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;


    /**
     * 用户登陆认证的sql
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username = #{username}")
    public UserInfo findByUsername(String username) throws Exception;
}
