package indi.baojie.demo.supervision.controller;

import indi.baojie.demo.supervision.service.UserService;
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
}
