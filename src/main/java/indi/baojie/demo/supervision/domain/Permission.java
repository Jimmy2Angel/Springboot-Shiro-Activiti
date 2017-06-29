package indi.baojie.demo.supervision.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Permission implements Serializable{
    private static final long serialVersionUID = 2380902884375259188L;
    private Integer permissionId;

    private String permissionName;

    private Set<Role> roles = new HashSet<>();

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}