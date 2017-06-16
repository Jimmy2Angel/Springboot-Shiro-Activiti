package indi.baojie.demo.activiti.identity;

import org.activiti.engine.impl.persistence.entity.UserEntityManager;

/**
 * Created by Lollipop on 2017/6/6.
 */
public class CustomUserEntityManager extends UserEntityManager {

//    @Autowired
//    private UserMapper userMapper;
//
    @Override
    public Boolean checkPassword(String userId, String password) {
//        com.lb.supervision.entity.User user = findByName(userId);
//        if(user!=null){
//            return user.getPassword().equals(MD5.MD5Encode(password));
//        }else {
//            return false;
//        }
        System.out.println("aaa");
        return true;
    }
//
//    @Override
//    public UserEntity findUserById(String userId) {
//        com.lb.supervision.entity.User user = findByName(userId);
//        if(user!=null){
//            return ActivitiUtil.changeToActivitiUser(user);
//        }else {
//            return null;
//        }
//    }
//
//    public com.lb.supervision.entity.User findByName(String userId){
//        UserExample userExample = new UserExample();
//        userExample.or().andNameEqualTo(userId);
//        List<com.lb.supervision.entity.User> users = userMapper.selectByExample(userExample);
//        if(users!=null && users.size()>0){
//            return users.get(0);
//        }else {
//            return null;
//        }
//    }
//
//        @Override
//    public List<Group> findGroupsByUser(String userId) {
//        System.out.println("自定义用户管理器的findGroupsByUser方法被调用了。。。");
//        List<Group> groups = new ArrayList<>();
//        Group group = new GroupEntity();
//
//        return groups;
//    }
//
//    @Override
//    public UserEntity createNewUser(String userId) {
//        throw new ActivitiException("This user manager doesn't support creating a new user");
//    }
//
//    @Override
//    public void updateUser(User updatedUser) {
//        throw new ActivitiException("This user manager doesn't support updating a user");
//    }
//
//    @Override
//    public boolean isNewUser(User user) {
//        throw new ActivitiException("This user manager doesn't support adding or updating a user");
//    }


}
