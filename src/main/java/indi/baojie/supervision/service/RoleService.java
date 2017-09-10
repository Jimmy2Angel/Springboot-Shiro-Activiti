package indi.baojie.supervision.service;

import indi.baojie.supervision.domain.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<String> getPermissionsName(Role role);

    List<Role> getAllByPaging(Integer pageNum, Integer pageSize);
}
