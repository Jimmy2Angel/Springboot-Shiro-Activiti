package indi.baojie.demo.supervision.service;

import indi.baojie.demo.supervision.domain.Role;

import java.util.Set;

/**
 * Created by Lollipop on 2017/6/19.
 */
public interface RoleService {

    Set<String> getPermissionsName(Role role);
}
