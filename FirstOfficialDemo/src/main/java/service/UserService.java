package service;

import domain.Login;
import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/*
用户管理业务接口
 */
public interface UserService {
    /*
    查询所有用户信息
     */
    public List<User> findAll();
    public void addUser(User user);
    public void deleteUserById(int id);
    public void register(Login login);
    public Login login(Login login);
    public void update(User user);
    public User findUserById(int id);
    public void deleteAll(String[] id);
    public int findTotalCount(Map<String, String[]> condition);
    public List<User> findByPage(int start,int row,Map<String, String[]> condition);
    public PageBean<User> findUserByPage(int currentPage, int row, Map<String, String[]> condition);
}
