package indi.baojie.demo.supervision.service;

import indi.baojie.demo.supervision.domain.User;

import java.util.Set;

/**
 * Created by Lollipop on 2017/6/16.
 */
public interface UserService {
    boolean addUser(User user);

    User getUser(int userId);

    User findByName(String loginName);

    Set<String> getRolesName(User user);
}
