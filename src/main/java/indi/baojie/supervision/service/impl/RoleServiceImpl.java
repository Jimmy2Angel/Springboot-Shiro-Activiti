package indi.baojie.supervision.service.impl;

import indi.baojie.supervision.domain.Permission;
import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.service.RoleService;
import org.assertj.core.util.Sets;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Set<String> getPermissionsName(Role role) {
        Set<Permission> permissions = role.getPermissions();
        Set<String> permissionNames = Sets.newHashSet();
        permissions.forEach(e -> {
            permissionNames.add(e.getName());
        });
        return permissionNames;
    }
}
