package indi.baojie.supervision.controller;

import com.github.pagehelper.PageInfo;
import indi.baojie.common.data.Constants;
import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.domain.Role;
import indi.baojie.supervision.domain.User;
import indi.baojie.supervision.service.RoleService;
import indi.baojie.supervision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 分页获取所有的user
     * @param pageNum
     * @return
     */
    @GetMapping("getByPage")
    @ResponseBody
    public PageInfo<User> getByPage(Integer pageNum) {
        List<User> userList = userService.getAllByPaging(pageNum, Constants.PAGE_SIZE);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @GetMapping("add")
    public String addUser() {
        return "user_add";
    }

    /**
     * 用户新增或修改处理
     * @param user
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public JsonResult addUser(User user) {
        if (user.getId() == null) {
            return userService.addOne(user);
        } else {
            return userService.editOne(user);
        }
    }

    @GetMapping("{userId}")
    public String showUser(@PathVariable Integer userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        return "user_add";
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
     * 给用户分配角色的页面显示
     * @return
     */
    @GetMapping("{userId}/roles")
    public String roleAssigned(@PathVariable Integer userId, Model model) {
        List<Role> allRoles = roleService.getAllByPaging(null, null);
        List<Role> selctedRoles = roleService.getRoleIdByUserId(userId);
        model.addAttribute("allRoles",allRoles);
        model.addAttribute("selectedRoles", selctedRoles);
        return "role_assigned";
    }

    /**
     * 给用户分配角色的处理
     * @param userId
     * @param roleIds
     * @return
     */
    @PostMapping("{userId}/roles")
    @ResponseBody
    public JsonResult roleAssigned(@PathVariable Integer userId, String roleIds) {
        JsonResult jsonResult = new JsonResult();
        boolean isSuccess = roleService.assigned(userId, roleIds);
        if (isSuccess) {
            jsonResult.markSuccess("分配成功", null);
        } else {
            jsonResult.markError("分配失败！请与管理员联系！");
        }
        return jsonResult;
    }

}
