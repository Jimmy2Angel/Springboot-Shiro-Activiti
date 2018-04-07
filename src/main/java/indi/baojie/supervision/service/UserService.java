package indi.baojie.supervision.service;

import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User findByName(String username);

    Set<String> findRolesName(User user);

    List<User> findAllByPaging(Integer pageNum, Integer pageSize);

    JsonResult saveOne(User user, String[] roleIds);

    User findById(Integer userId);

    JsonResult updateOne(User user, String[] roleIds);

    boolean deleteById(Integer userId);
}
