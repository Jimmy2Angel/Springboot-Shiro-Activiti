package indi.baojie.supervision.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Sets;
import com.sun.tools.javadoc.Start;
import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.dao.UserMapper;
import indi.baojie.supervision.dao.UserRoleMapper;
import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.domain.User;
import indi.baojie.supervision.domain.UserRole;
import indi.baojie.supervision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public User findByName(String username) {
        User user0 = new User();
        user0.setUsername(username);
        return userMapper.findOne(user0);
    }

    @Override
    public Set<String> getRolesName(User user) {
        Set<Role> roles = user.getRoles();
        Set<String> roleNames = Sets.newHashSet();
        roles.forEach(e -> {
            roleNames.add(e.getName());
        });
        return roleNames;
    }

    @Override
    public List<User> getAllByPaging(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.find(new User());
    }

    @Override
    public JsonResult addOne(User user, String[] roleIds) {
        JsonResult jsonResult = new JsonResult();
        int count = userMapper.count(user);
        if (count != 0) {
            jsonResult.markError("该用户名已经存在！");
            return jsonResult;
        } else {
            user.setPassword("111111");
            if (userMapper.insert(user)==0) {
                jsonResult.markError("新增失败！请联系管理员！");
                return jsonResult;
            }
        }
        jsonResult.markSuccess("新增成功！", null);
        return jsonResult;
    }

    @Override
    public User findById(Integer userId) {
        User user = new User();
        user.setId(userId);
        return userMapper.findOne(user);
    }

    @Override
    public JsonResult editOne(User user, String[] roleIds) {
        JsonResult jsonResult = new JsonResult();
        if (userMapper.count(user) > 1) {
            jsonResult.markError("该用户名已经存在！");
            return jsonResult;
        } else if(userMapper.update(user) == 0) {
            jsonResult.markError("修改失败！请联系管理员！");
            return jsonResult;
        }
        if (roleIds != null) {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRoleMapper.delete(userRole);
            for (String roleId:roleIds) {
                userRole.setRoleId(Integer.valueOf(roleId));
                userRoleMapper.insert(userRole);
            }
        }
        jsonResult.markSuccess("修改成功！", null);
        return jsonResult;
    }

    @Override
    public boolean deleteById(Integer userId) {
        User user = new User();
        user.setId(userId);
        if (userMapper.delete(user) != 1) {
            return false;
        }
        userRoleMapper.deleteByUserId(userId);
        return true;
    }

}
