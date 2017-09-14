package indi.baojie.supervision.service;

import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User findByName(String username);

    Set<String> getRolesName(User user);

    List<User> getAllByPaging(Integer pageNum, Integer pageSize);

    JsonResult addOne(User user, String[] roleIds);

    User findById(Integer userId);

    JsonResult editOne(User user, String[] roleIds);

    boolean deleteById(Integer userId);
}
