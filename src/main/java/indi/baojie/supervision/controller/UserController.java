package indi.baojie.supervision.controller;

import com.github.pagehelper.PageInfo;
import indi.baojie.common.data.Constants;
import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.domain.Permission;
import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.domain.User;
import indi.baojie.supervision.service.PermissionService;
import indi.baojie.supervision.service.RoleService;
import indi.baojie.supervision.service.UserService;
import indi.baojie.supervision.utils.SessionUserUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("sys")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 分页获取所有的user
     * @param pageNum
     * @return
     */
    @GetMapping("user/getByPage")
    @ResponseBody
    public PageInfo<User> getByPage(Integer pageNum) {
        List<User> userList = userService.getAllByPaging(pageNum, Constants.PAGE_SIZE);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @GetMapping("user/add")
    public String addUser(Model model) {
        model.addAttribute("roles", roleService.getAllByPaging(null,null));
        return "user_add";
    }

    /**
     * 用户新增或修改处理
     * @param user
     * @return
     */
    @PostMapping("user/add")
    @ResponseBody
    public JsonResult addUser(User user, String[] roleIds) {
        if (user.getId() == null) {
            return userService.addOne(user, roleIds);
        } else {
            return userService.editOne(user, roleIds);
        }
    }

    @GetMapping("user/{userId}")
    public String showUser(@PathVariable Integer userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("roles",roleService.getAllByPaging(null, null));
        return "user_add";
    }

    @DeleteMapping("user/{userId}")
    @ResponseBody
    public JsonResult deleteUser(@PathVariable Integer userId) {
        JsonResult jsonResult = new JsonResult();
        boolean isSuccess = userService.deleteById(userId);
        if (isSuccess) {
            jsonResult.markSuccess("删除成功！", null);
        } else {
            jsonResult.markError("删除失败！请与管理员联系！");
        }
        return jsonResult;
    }

    /**
     * 分页获取所有的role
     * @param pageNum
     * @return
     */
    @GetMapping("role/getByPage")
    @ResponseBody
    public PageInfo<Role> getRolesByPage(Integer pageNum) {
        List<Role> userList = roleService.getAllByPaging(pageNum, Constants.PAGE_SIZE);
        PageInfo<Role> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @GetMapping("role/add")
    public String addRole() {
        return "role_add";
    }

    @GetMapping("role/{roleId}")
    public String showRole(@PathVariable Integer roleId, Model model) {
        model.addAttribute("role", roleService.getById(roleId));
        return "role_add";
    }

    /**
     * 角色新增或修改处理
     * @param role
     * @return
     */
    @PostMapping("role/add")
    @ResponseBody
    public JsonResult addRole(Role role) {
        if (role.getId() == null) {
            return roleService.addOne(role);
        } else {
            return roleService.editOne(role);
        }
    }

    /**
     * 分页获取所有的permission
     * @return
     */
    @GetMapping("permission/getByPage")
    @ResponseBody
    public PageInfo<Permission> getPermissionByPage(Integer pageNum) {
        List<Permission> permissionList = permissionService.getAllByPaging(pageNum, Constants.PAGE_SIZE);
        return new PageInfo<>(permissionList);
    }


}
