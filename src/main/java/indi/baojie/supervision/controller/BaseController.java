package indi.baojie.supervision.controller;

import indi.baojie.supervision.domain.User;
import indi.baojie.supervision.service.UserService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
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
    protected TaskService taskService;
    @Autowired
    protected RuntimeService runtimeService;
    @Autowired
    protected HistoryService historyService;
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
        Session session = SecurityUtils.getSubject().getSession();
        //此处会强转失败
        return (User) session.getAttribute("user");
    }
}
