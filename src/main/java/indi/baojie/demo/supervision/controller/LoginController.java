package indi.baojie.demo.supervision.controller;

import com.fasterxml.jackson.databind.deser.Deserializers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Lollipop on 2017/6/15.
 */
@RestController
public class LoginController extends Deserializers.Base{

    /**
     * 打开登陆页面
     * @return
     */
    @RequestMapping("login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("url","doLogin.do");
        return modelAndView;
    }

}
