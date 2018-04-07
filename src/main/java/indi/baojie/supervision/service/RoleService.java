package indi.baojie.supervision.service;

import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.domain.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<String> findPermissionsName(Role role);

    List<Role> findAllByPaging(Integer pageNum, Integer pageSize);

    Role findById(Integer roleId);

    JsonResult saveOne(Role role);

    JsonResult updateOne(Role role);

    List<Role> findRoleIdByUserId(Integer userId);

    boolean saveUserRoles(Integer userId, String roleIds);
}
