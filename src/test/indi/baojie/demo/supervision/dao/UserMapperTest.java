package indi.baojie.demo.supervision.dao;

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
@SpringBootTest()
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectByName() throws Exception {
        User user = userMapper.selectByName("leader");
        System.out.println(user);
    }
}