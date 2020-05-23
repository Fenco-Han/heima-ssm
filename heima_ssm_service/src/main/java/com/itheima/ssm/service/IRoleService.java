package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: hanpengfei
 * @Date: 2020/5/13 22:04
 * heima_ssm
 */
public interface IRoleService {
    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    public List<Role> findAll() throws Exception;

    /**
     * 角色保存
     * @param role
     * @throws Exception
     */
    public void save(Role role) throws Exception;

    /**
     * 给角色添加权限
     * @param permissionId
     * @param roleId
     * @throws Exception
     */
    public void addPermissionToRole(String[] permissionIds,String  roleId) throws Exception;
}
