package dao;

import domain.Login;
import domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public Login login(Login login);
    public void addUser(User user);
    public void register(Login login);
    public void deleteUserById(int id);
    public void update(User user);
    public User findUserById(int id);
}
