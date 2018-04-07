package indi.baojie.supervision.dao;

import indi.baojie.supervision.domain.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper extends BaseMapper<UserRole> {
    void deleteByUserId(@Param("userId") Integer userId);
}
