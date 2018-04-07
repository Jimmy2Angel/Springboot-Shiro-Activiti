package indi.baojie.supervision.service.impl;

import indi.baojie.supervision.domain.Permission;
import indi.baojie.supervision.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lollipop
 * @date: 18/1/12
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public List<Permission> findAllByPaging(Integer pageNum, Integer pageSize) {
        return null;
    }
}
