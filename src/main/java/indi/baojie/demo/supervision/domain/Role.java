package indi.baojie.demo.supervision.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{
    private static final long serialVersionUID = 941613016380559279L;
    private Integer roleId;

    private String roleName;

    private List<Permission> permissionList;

    private List<User> userList;

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", permissionList=" + permissionList +
                ", userList=" + userList +
                '}';
    }
}