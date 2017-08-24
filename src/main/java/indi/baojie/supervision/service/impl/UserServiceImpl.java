package indi.baojie.supervision.service.impl;

import com.google.common.collect.Sets;
import indi.baojie.supervision.dao.UserMapper;
import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.domain.User;
import indi.baojie.supervision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

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
}
