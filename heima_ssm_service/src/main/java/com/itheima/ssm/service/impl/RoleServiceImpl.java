package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: hanpengfei
 * @Date: 2020/5/13 22:04
 * heima_ssm
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleDao roleDao;

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    /**
     * 保存角色
     * @param role
     * @throws Exception
     */
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    /**
     * 给角色添加权限
     * @param permissionId
     * @param roleId
     * @throws Exception
     */
    @Override
    public void addPermissionToRole(String[] permissionIds, String roleId) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(permissionId, roleId);
        }
    }
}
