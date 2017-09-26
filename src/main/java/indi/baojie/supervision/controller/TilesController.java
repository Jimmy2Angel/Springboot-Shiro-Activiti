package indi.baojie.supervision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lollipop on 17/9/20
 */
@Controller
public class TilesController {

    @GetMapping("user")
    public String showUser() {
        return "pages/user/user_list";
    }

    @GetMapping("role")
    public String showRole() {
        return "pages/user/role_list";
    }

    @GetMapping("permission")
    public String showPermission() {
        return "pages/user/permission_list";
    }


    @GetMapping("process")
    public String showProcess() {
        return "process";
    }
}
