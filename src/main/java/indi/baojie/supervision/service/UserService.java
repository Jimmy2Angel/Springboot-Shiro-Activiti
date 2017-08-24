package indi.baojie.supervision.service;

import indi.baojie.supervision.domain.User;

import java.util.Set;

public interface UserService {

    User findByName(String username);

    Set<String> getRolesName(User user);
}
