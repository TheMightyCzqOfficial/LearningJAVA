package dao.impl;

import dao.UserDao;
import domain.Login;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDatasource());
    @Override
    public List<User> findAll() {
        String sql="select * from user";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public Login login(Login login) {
        String sql="select * from login where user=? and password=?";

        Login l = null;
        try {
            l = template.queryForObject(sql, new BeanPropertyRowMapper<Login>(Login.class), login.getUser(), login.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }


        return l;
    }

    @Override
    public void addUser(User user) {
        String sql="insert into user(name,gender,age,address,qq,email) value(?,?,?,?,?,?)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void register(Login login) {
        String sql="insert into login(user,password) value(?,?)";
        template.update(sql, login.getUser(),login.getPassword());
    }

    @Override
    public void deleteUserById(int id) {
        String sql="delete from user where id=?";
        template.update(sql, id);
    }

    @Override
    public void update(User user) {
        String sql="update user set gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }



    @Override
    public User findUserById(int id) {
        String sql="select * from user where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

}
