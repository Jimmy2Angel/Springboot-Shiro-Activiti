package indi.baojie.supervision.service.impl;

import com.github.pagehelper.PageHelper;
import indi.baojie.common.data.Constants;
import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.dao.RoleMapper;
import indi.baojie.supervision.dao.UserRoleMapper;
import indi.baojie.supervision.domain.Permission;
import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.domain.UserRole;
import indi.baojie.supervision.service.RoleService;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public Set<String> getPermissionsName(Role role) {
        Set<Permission> permissions = role.getPermissions();
        Set<String> permissionNames = Sets.newHashSet();
        permissions.forEach(e -> {
            permissionNames.add(e.getName());
        });
        return permissionNames;
    }

    @Override
    public List<Role> getAllByPaging(Integer pageNum, Integer pageSize) {
        if (pageNum != null) {
            PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        }
        return roleMapper.find(new Role());
    }

    @Override
    public Role getById(Integer roleId) {
        Role role = new Role();
        role.setId(roleId);
        return roleMapper.findOne(role);
    }

    @Override
    public JsonResult addOne(Role role) {
        JsonResult jsonResult = new JsonResult();
        int count = roleMapper.count(role);
        if (count != 0) {
            jsonResult.markError("该角色名已经存在！");
            return jsonResult;
        } else {
            if (roleMapper.insert(role)==0) {
                jsonResult.markError("新增失败！请联系管理员！");
                return jsonResult;
            }
        }
        jsonResult.markSuccess("新增成功！", null);
        return jsonResult;
    }

    @Override
    public JsonResult editOne(Role role) {
        JsonResult jsonResult = new JsonResult();
        if (roleMapper.count(role) > 1) {
            jsonResult.markError("该角色名已经存在！");
            return jsonResult;
        } else if(roleMapper.update(role) == 0) {
            jsonResult.markError("修改失败！请联系管理员！");
            return jsonResult;
        }
        jsonResult.markSuccess("修改成功！", null);
        return jsonResult;
    }

    @Override
    public List<Role> getRoleIdByUserId(Integer userId) {
        List<Role> result = Lists.newArrayList();
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        List<UserRole> userRoles = userRoleMapper.find(userRole);
        Role role = new Role();
        userRoles.forEach(e -> {
            role.setId(e.getRoleId());
            result.add(roleMapper.findOne(role));
        });
        return result;
    }

    @Override
    public boolean assigned(Integer userId, String roleIds) {
        String[] roleIdsArr = roleIds.split(",");
        UserRole userRole = new UserRole();
        for (String roleId: roleIdsArr) {
            userRole.setUserId(userId);
            userRole.setRoleId(Integer.valueOf(roleId));
            if (userRoleMapper.count(userRole) == 0) {
                if (userRoleMapper.insert(userRole) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
