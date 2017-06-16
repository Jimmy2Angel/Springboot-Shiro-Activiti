package indi.baojie.demo.activiti.identity;

import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lollipop on 2017/6/6.
 */
public class CustomGroupEntityManager extends GroupEntityManager {

//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public List<Group> findGroupsByUser(String userId) {
//        System.out.println("自定义组管理器的findGroupsByUser方法被调用了。。。。。。");
//        List<Group> groups = new ArrayList<>();
//        User user = findByName(userId);
//        if(user!=null){
//            Integer organizerId = user.getOrganizerId();
//            if(organizerId!=null){
//                Group group = new GroupEntity();
//                group.setId(String.valueOf(organizerId));
//                groups.add(group);
//            }
//        }
//        return groups;
//    }
//
//    public User findByName(String userId){
//        UserExample userExample = new UserExample();
//        userExample.or().andNameEqualTo(userId);
//        List<com.lb.supervision.entity.User> users = userMapper.selectByExample(userExample);
//        if(users!=null && users.size()>0){
//            return users.get(0);
//        }else {
//            return null;
//        }
//    }

}
