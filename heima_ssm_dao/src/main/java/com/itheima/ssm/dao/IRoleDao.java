package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: hanpengfei
 * @Date: 2020/5/13 22:06
 * heima_ssm
 */
public interface IRoleDao {
    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    /**
     * 角色保存
     * @param role
     * @throws Exception
     */
    @Insert("insert into role (roleNum, roleDesc) values (#{roleNum}, #{roleDesc})")
    public void save(Role role) throws Exception;

    /**
     * 给角色添加权限
     * @param permissionId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into role_permission (permissionId, roleId) values (#{permissionId,#{roleId})")
    public void addPermissionToRole(@Param("permissionId") String permissionId, @Param("roleId") String roleId) throws Exception;

    /**
     * 根据userId查询对应角色，查询用户详情时使用
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permission", column = "id",javaType = java.util.List.class, many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;
}
