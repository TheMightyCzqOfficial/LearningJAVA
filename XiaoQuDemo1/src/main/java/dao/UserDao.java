package dao;

import domain.Login;
import domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();//查询所有用户信息
    public Login login(Login login);//验证登录信息
    public void addUser(User user);//添加用户
    public void register(Login login);//添加新注册用户
    public void deleteUserById(int id);//根据id删除用户
    public void update(User user);//修改用户
    public User findUserById(int id);//修改用户之前传递参数id
    public List<String> findLogin();//查询注册用户
    public void deleteAll(String[] id);//删除选中用户
    public List<User> findByPage(int start, int row, Map<String, String[]> condition);//分页查询
    public int findTotalCount(Map<String, String[]> condition);//查询总页数
    public void updatePwd(String username,String pwd);//修改密码
    public String findActivateUser(String username);//查询用户激活状态
    public List finUsername();//查询用户名
    public int  findUnDo();//查询未处理的信息
}
