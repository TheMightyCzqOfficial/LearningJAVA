package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.Login;
import domain.User;
import service.UserService;

import java.util.List;

/*
实现类
 */
public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        dao.deleteUserById(id);
    }

    @Override
    public void register(Login login) {
        dao.register(login);
    }

    @Override
    public Login login(Login login) {
        return dao.login(login);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public User findUserById(int id) {
        return dao.findUserById(id);
    }
}
