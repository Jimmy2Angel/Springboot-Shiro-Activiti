package indi.baojie.supervision.controller;

import com.github.pagehelper.PageInfo;
import indi.baojie.common.data.Constants;
import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.domain.User;
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

    @GetMapping("getByPage")
    @ResponseBody
    public PageInfo<User> getByPage(Integer pageNum) {
        List<User> userList = userService.getAllByPaging(pageNum, Constants.PAGE_SIZE);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @GetMapping("add")
    public String add() {
        return "user_add";
    }

    /**
     * 新增或修改
     * @param user
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public JsonResult add(User user) {
        if (user.getId() == null) {
            return userService.addOne(user);
        } else {
            return userService.editOne(user);
        }
    }

    @GetMapping("{userId}")
    public String show(@PathVariable Integer userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        return "user_add";
    }
}
