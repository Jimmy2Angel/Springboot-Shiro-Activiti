package indi.baojie.supervision.service.impl;

import com.github.pagehelper.PageHelper;
import indi.baojie.common.data.Constants;
import indi.baojie.supervision.dao.RoleMapper;
import indi.baojie.supervision.domain.Permission;
import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.service.RoleService;
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

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
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        return roleMapper.find(new Role());
    }
}
