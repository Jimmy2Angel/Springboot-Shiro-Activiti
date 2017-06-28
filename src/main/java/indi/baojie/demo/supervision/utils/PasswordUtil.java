package indi.baojie.demo.supervision.utils;

import indi.baojie.demo.supervision.domain.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by Lollipop on 2017/6/27.
 */
public class PasswordUtil {
    //private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void encryptPassword(User user) {
        //String salt=randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getUserName()), hashIterations).toHex();
        //String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
        user.setPassword(newPassword);

    }
    public static void main(String[] args) {
        PasswordUtil passwordUtil = new PasswordUtil();
        User user = new User();
        user.setUserName("leader");
        user.setPassword("111");
        passwordUtil.encryptPassword(user);
        System.out.println(user);
    }
}
