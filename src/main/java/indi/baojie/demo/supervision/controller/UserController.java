package indi.baojie.demo.supervision.controller;

import indi.baojie.demo.common.data.JsonResult;
import indi.baojie.demo.supervision.domain.User;
import indi.baojie.demo.supervision.service.UserService;
import indi.baojie.demo.supervision.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lollipop on 2017/6/16.
 */
@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable("userId") int userId){
        return userService.getUser(userId).toString();
    }

    @RequestMapping(value = "/add")
    public JsonResult addUser(User user) {
        JsonResult jsonResult = new JsonResult();
        User u = userService.findByName(user.getUserName());
        if(u != null) {
            jsonResult.markError("该用户名已存在，请换个名字试试");
            return jsonResult;
        }
        try {
            PasswordUtil passwordUtil = new PasswordUtil();
            passwordUtil.encryptPassword(user);
            userService.addUser(user);
            jsonResult.setSuccess(true);
            return  jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.markError("添加异常，请联系管理员！");
            return jsonResult;
        }
    }
}
