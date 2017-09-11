package indi.baojie.supervision.service;

import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.domain.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<String> getPermissionsName(Role role);

    List<Role> getAllByPaging(Integer pageNum, Integer pageSize);

    Role getById(Integer roleId);

    JsonResult addOne(Role role);

    JsonResult editOne(Role role);

    List<Role> getRoleIdByUserId(Integer userId);

    boolean assigned(Integer userId, String roleIds);
}
