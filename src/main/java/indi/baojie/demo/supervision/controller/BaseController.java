package indi.baojie.demo.supervision.controller;

import indi.baojie.demo.supervision.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Lollipop on 2017/6/15.
 */
public class BaseController {

    static String CURRENT_USER = "user";

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
        Session session = SecurityUtils.getSubject().getSession();
        return (User) session.getAttribute("userSession");
    }
}
