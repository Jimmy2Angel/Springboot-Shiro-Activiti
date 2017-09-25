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
        return "user";
    }


    @GetMapping("process")
    public String showProcess() {
        return "process";
    }
}
