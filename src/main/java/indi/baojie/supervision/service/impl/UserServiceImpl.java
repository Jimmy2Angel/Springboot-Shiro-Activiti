package indi.baojie.supervision.service.impl;

import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.domain.User;
import indi.baojie.supervision.service.UserService;
import indi.baojie.supervision.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lollipop on 2017/6/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return userMapper.insert(user)==1;
    }

    @Override
    public User getUser(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User findByName(String loginName) {
        return userMapper.selectByName(loginName);
    }

    @Override
    public Set<String> getRolesName(User user) {
        Set<Role> roles = user.getRoles();
        Set<String> set = new HashSet<String>();
        for (Role role : roles) {
            set.add(role.getRoleName());
        }
        return set;
    }
}
