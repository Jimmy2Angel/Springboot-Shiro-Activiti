package indi.baojie.supervision.service.impl;

import indi.baojie.supervision.domain.Permission;
import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lollipop on 2017/6/19.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public Set<String> getPermissionsName(Role role) {
        Set<String> set = new HashSet<>();
        Set<Permission> perlist = role.getPermissions();
        for (Permission per : perlist) {
            set.add(per.getPermissionName());
        }
        return set;
    }
}
