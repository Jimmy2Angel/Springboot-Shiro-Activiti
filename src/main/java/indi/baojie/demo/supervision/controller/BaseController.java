package indi.baojie.demo.supervision.controller;

import indi.baojie.demo.supervision.domain.User;
import indi.baojie.demo.supervision.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Lollipop on 2017/6/15.
 */
@Controller
public class BaseController {

    static String CURRENT_USER = "user";

    @Autowired
    private UserService userService;

    /**
     * 保存用户到session
     */
    protected void saveUser(HttpServletRequest request,User user){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.setAttribute(CURRENT_USER,user);
            session.setMaxInactiveInterval(7200);
        }
    }

    /**
     * 从session中获取用户
     * @return
     */
    public User currentUser(){
//        Session session = SecurityUtils.getSubject().getSession();
//        //此处会强转失败
//        return (User) session.getAttribute("user");

        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getPrincipal();
        System.out.println(subject.isAuthenticated());
        System.out.println("object.getClass()========"+subject.getPrincipal().getClass());
        System.out.println(subject.getPrincipal() instanceof User);
        return (User)object;
    }
}
