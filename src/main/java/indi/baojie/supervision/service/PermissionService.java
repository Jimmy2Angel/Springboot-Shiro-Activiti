package indi.baojie.supervision.service;

import indi.baojie.supervision.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getAllByPaging(Integer pageNum, Integer pageSize);
}
