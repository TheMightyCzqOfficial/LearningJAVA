package test;

import Dao.UserDao;
import domain.User;
import org.junit.Test;


public class UserDaoTest {
    @Test
    public void loginTest(){
        User user=new User();
        user.setUsername("czq");
        user.setPassword("123456");
        UserDao ud=new UserDao();
        User loginuser = ud.login(user);
        System.out.println(loginuser);
    }
}
