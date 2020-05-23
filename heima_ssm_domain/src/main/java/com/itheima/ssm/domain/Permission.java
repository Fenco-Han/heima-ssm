package com.itheima.ssm.domain;

import java.util.List;

/**
 * @author FENCO
 * @date 2020/1/2 14:11
 * @company HOWSO
 */
public class Permission {

    /**
     * 主键
     */
    private String id;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 资源路径
     */
    private String url;


    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
