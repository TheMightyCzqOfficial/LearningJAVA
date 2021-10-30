package Dao;

import domain.User;
import jdbcUtils.utils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate template=new JdbcTemplate(utils.getDatasource());//获取jdbctemplate对象，通过其执行sql语句并返回
    public User login(User loginUser){
        String sql="select * from users where username=? and password=?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }
}
