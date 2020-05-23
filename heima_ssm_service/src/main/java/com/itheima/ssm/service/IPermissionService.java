package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @Author: hanpengfei
 * @Date: 2020/5/13 22:18
 * heima_ssm
 */
public interface IPermissionService {
    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    public List<Permission> findAll() throws Exception;

    /**
     * 保存新增权限
     * @param permission
     * @throws Exception
     */
    public void save(Permission permission) throws Exception;
}
