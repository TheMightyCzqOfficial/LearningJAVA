package dao.impl;

import dao.UserDao;
import domain.Login;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
        String sql="insert into user(name,sex,mobil,email,type,house) value(?,?,?,?,?,?)";
        template.update(sql, user.getName(), user.getSex(), user.getMobil(), user.getEmail(), user.getType(), user.getHouse());
    }

    @Override
    public void register(Login login) {
        String sql="insert into login(user,password,type) value(?,?,?)";
        template.update(sql, login.getUser(),login.getPassword(),1);
    }

    @Override
    public void deleteUserById(int id) {
        String sql="delete from user where id=?";
        template.update(sql, id);
    }

    @Override
    public void update(User user) {
        String sql="update user set sex=?,mobil=?,email=? where id=?";
        template.update(sql,user.getSex(),user.getMobil(),user.getEmail(),user.getId());
    }



    @Override
    public User findUserById(int id) {
        String sql="select * from user where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void deleteAll(String[] id) {
        for (String uid:id){
            int intid=Integer.parseInt(uid);
            deleteUserById(intid);
        }
    }

    @Override
    public List<User> findByPage(int start, int row, Map<String, String[]> condition) {
        String sql="select * from user where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        for (String key:keySet){
            if (key.equals("currentPage")){
                continue;
            }
            String value = condition.get(key)[0];
            sb.append("and "+key+" like \"%"+value+"%\"");
        }
        sb.append(" limit ?,?");
        List<User> userList = template.query(sb.toString(), new BeanPropertyRowMapper<>(User.class),start, row);
        return userList;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql="select count(*) from user where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        Set<String> keySet = null;

            keySet = condition.keySet();

        for (String key:keySet){
            if (key.equals("currentPage")){
                continue;
            }
            String value = condition.get(key)[0];
            sb.append("and "+key+" like \"%"+value+"%\"");
        }

        Map<String, Object> map = template.queryForMap(sb.toString());
        Number count= (Number) map.get("count(*)");
        return count.intValue();
    }


}
