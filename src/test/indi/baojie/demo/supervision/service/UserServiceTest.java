package indi.baojie.demo.supervision.service;

import indi.baojie.demo.supervision.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Lollipop on 2017/6/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetRolesName() throws Exception {
        User user = userService.findByName("leader");
        System.out.println();
        System.out.println(userService.getRolesName(user));
    }
}