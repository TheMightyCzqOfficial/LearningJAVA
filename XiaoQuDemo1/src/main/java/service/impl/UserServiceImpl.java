package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.Login;
import domain.PageBean;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import service.UserService;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;

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

    @Override
    public void deleteAll(String[] id) {
        dao.deleteAll(id);
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        return dao.findTotalCount(condition);
    }

    @Override
    public List<User> findByPage(int start, int row,Map<String, String[]> condition) {
        return dao.findByPage(start, row, condition);
    }

    @Override
    public PageBean<User> findUserByPage(int currentPage, int row, Map<String, String[]> condition) {
        PageBean<User> pageBean=new PageBean<>();
        int totalCount = dao.findTotalCount(condition);
        int start=(currentPage-1)*row;
        int totalPage = (totalCount%row)==0?(totalCount/row):(totalCount/row)+1;
        List<User> userList = dao.findByPage(start, row,condition);

        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        pageBean.setRow(row);
        pageBean.setList(userList);
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }

    @Override
    public List<Login> findRegister(String username) {
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDatasource());
        String sql="select user from login where user=?";
        List<Login> query = template.query(sql, new BeanPropertyRowMapper<>(Login.class), username);
        return query;
    }

    @Override
    public List<String> findLogin() {
        return dao.findLogin();
    }

    @Override
    public void updatePwd(String username, String pwd) {
        dao.updatePwd(username,pwd);
    }

    @Override
    public String findActivateUser(String username) {
        return dao.findActivateUser(username);
    }
    @Override
    public List findUsername() {

        return dao.finUsername();


    }

    @Override
    public int findUnDo() {
        return dao.findUnDo();
    }
}
