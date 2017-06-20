package indi.baojie.demo.supervision.controller;

import indi.baojie.demo.common.data.JsonResult;
import indi.baojie.demo.supervision.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.mozilla.javascript.SecurityController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Lollipop on 2017/6/15.
 */
@RestController
public class LoginController{

    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    /**
     * 打开登陆页面
     * @return
     */
    @GetMapping(value = {"/login"})
    public ModelAndView login(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated() || subject.isRemembered()) {
            return new ModelAndView("redirect:/index");
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("url","login");
        return modelAndView;
    }

    @PostMapping("/login")
    public JsonResult login(String username, String password,Boolean rememberMe, HttpServletRequest req,
                            RedirectAttributes redirectAttributes){
        System.out.println(username+"======="+password+"=========="+rememberMe);
        JsonResult jsonResult = new JsonResult();
        logger.info("准备登陆用户 => {}", username);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.info("对用户[" + username + "]进行登录验证..验证开始");
            currentUser.login(token);
            logger.info("对用户[" + username + "]进行登录验证..验证通过");
        } catch (UnknownAccountException uae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            redirectAttributes.addFlashAttribute("message", "未知账户");
        } catch (IncorrectCredentialsException ice) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            redirectAttributes.addFlashAttribute("message", "密码不正确");
        } catch (LockedAccountException lae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            redirectAttributes.addFlashAttribute("message", "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
        }
        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            logger.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            jsonResult.setSuccess(true);
            return  jsonResult;
        } else {
            jsonResult.markError("账号或密码不正确");
            return  jsonResult;
        }
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated() || subject.isRemembered()) {
            // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            subject.logout();
        }
        return new ModelAndView("redirect:/login");
    }

    /**
     * 访问未授权页面时的跳转
     */
    @GetMapping("/unauthorized")
    public ModelAndView unauthorized(){
        logger.info("------没有权限-------");
        return new ModelAndView("unauthorized");
    }

}
