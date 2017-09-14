package indi.baojie.supervision.service.impl;

import com.github.pagehelper.PageHelper;
import indi.baojie.supervision.dao.PermissionMapper;
import indi.baojie.supervision.domain.Permission;
import indi.baojie.supervision.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> getAllByPaging(Integer pageNum, Integer pageSize) {
        if (pageNum != null) {
            PageHelper.startPage(pageNum,pageSize);
        }
        return permissionMapper.find(new Permission());
    }
}
