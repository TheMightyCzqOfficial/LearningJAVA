package dao;

import domain.Login;
import domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();
    public Login login(Login login);
    public void addUser(User user);
    public void register(Login login);
    public void deleteUserById(int id);
    public void update(User user);
    public User findUserById(int id);
    public void deleteAll(String[] id);
    public List<User> findByPage(int start, int row, Map<String, String[]> condition);
    public int findTotalCount(Map<String, String[]> condition);
}
