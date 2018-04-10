package indi.baojie.supervision.shiro;

import indi.baojie.supervision.domain.User;
import indi.baojie.supervision.service.RoleService;
import indi.baojie.supervision.service.UserService;
import indi.baojie.supervision.utils.SessionUserUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.provider.MD5;

import java.security.MessageDigest;

/**
 * Created by Lollipop on 2017/6/19.
 */
public class MyShiroRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 权限认证，为当前登录的Subject授予角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        logger.info("##################执行Shiro权限认证##################");
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
        String username = (String)super.getAvailablePrincipal(principalCollection);
        //到数据库查是否有此对象
        User user=userService.findByName(username);
        if(user!=null){
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            //用户的角色集合
            info.setRoles(userService.findRolesName(user));
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
            user.getRoles().forEach(role -> {
                info.addStringPermissions(roleService.findPermissionsName(role));
            });
            // 或者按下面这样添加
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
//            simpleAuthorInfo.addRole("admin");
            //添加权限
//            simpleAuthorInfo.addStringPermission("admin:manage");
//            logger.info("已为用户[mike]赋予了[admin]角色和[admin:manage]权限");
            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        User user = userService.findByName(username);
        if(user==null) {
            throw new UnknownAccountException();
        }
        SessionUserUtil.save(user);
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
