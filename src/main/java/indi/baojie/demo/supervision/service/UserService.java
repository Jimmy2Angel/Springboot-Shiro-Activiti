package indi.baojie.demo.supervision.service;

import indi.baojie.demo.supervision.domain.User;

/**
 * Created by Lollipop on 2017/6/16.
 */
public interface UserService {
    boolean addUser(User user);

    User getUser(int userId);
}
