package indi.baojie.supervision.controller;

import indi.baojie.supervision.utils.SessionUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lollipop on 17/9/20
 */
@Controller
public class TilesController {

    @GetMapping("user")
    public ModelAndView showUserPage() {
        return new ModelAndView("user", "username", SessionUserUtil.current().getUsername());
    }
}
