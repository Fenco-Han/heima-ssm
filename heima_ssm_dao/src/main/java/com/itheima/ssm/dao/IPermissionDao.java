package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hanpengfei
 * @Date: 2020/5/13 22:21
 * heima_ssm
 */
public interface IPermissionDao {
    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    @Select("select * from permission")
    public List<Permission> findAll() throws Exception;

    /**
     * 保存所有权限
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission (permissionName, url) values (#{permission}, #{url})")
    public void save(Permission permission) throws Exception;

    /**
     * 根据roleid查询角色具有的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    public List<Permission> findPermissionByRoleId(String roleId) throws Exception;
}
