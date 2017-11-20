package indi.baojie.supervision.controller;

import indi.baojie.common.data.Constants;
import indi.baojie.common.data.JsonResult;
import indi.baojie.supervision.domain.User;
import indi.baojie.supervision.utils.RequestUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: lollipop
 * @date: 17/9/5
 */
@Controller
@RequestMapping("a")
public class LoginController {

    @RequestMapping("login")
    public String login () {
        if (RequestUtil.getRequest().getSession().getAttribute(Constants.SESSION_USER) != null) {
            return "redirect:/index";
        }
        return "admin/login";
    }

    @PostMapping("login")
    @ResponseBody
    public JsonResult login(User user) {
        JsonResult jsonResult = new JsonResult();
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            jsonResult.markError("用户名或密码不能为空！");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            jsonResult.markSuccess("登录成功", null);
        } catch (LockedAccountException lae) {
            token.clear();
            jsonResult.markError("用户已经被锁定不能登录，请与管理员联系！");
        } catch (AuthenticationException e) {
            token.clear();
            jsonResult.markError("用户名或密码不正确！");
        } finally {
            return jsonResult;
        }
    }

    @GetMapping("logout")
    public String logout() {
        RequestUtil.getRequest().getSession().invalidate();
        return "redirect:/login";
    }

    @GetMapping("index")
    public String index() {
        return "index";
    }
}
