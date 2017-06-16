package indi.baojie.demo.supervision.service.impl;

import indi.baojie.demo.supervision.dao.UserMapper;
import indi.baojie.demo.supervision.domain.User;
import indi.baojie.demo.supervision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
