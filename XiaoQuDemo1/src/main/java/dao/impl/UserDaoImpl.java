package dao.impl;

import dao.UserDao;
import domain.Login;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
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
        String sql="insert into user(name,sex,mobil,email,type,house,username) value(?,?,?,?,?,?,?)";
        template.update(sql, user.getName(), user.getSex(), user.getMobil(), user.getEmail(), user.getType(), user.getHouse(),user.getUsername());
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
    public List<String> findLogin() {
        List<String> username=new ArrayList<>();
        String sql= "select user from login where user not in(SELECT username from user)";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map:maps){
            String user = map.get("user").toString();
            username.add(user);
        }
        return username;
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

    @Override
    public void updatePwd(String username,String pwd) {
        String sql="update login set password=? where user=?";
        template.update(sql,pwd,username);
    }

    @Override//查询用户激活状态
    public String findActivateUser(String username) {
        String username1 = null;
        try {
            String sql="select username from user where username=?";
            List<Map<String, Object>> maps = template.queryForList(sql, username);
            Map<String, Object> map = maps.get(0);
            username1 = map.get("username").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username1;
    }

    @Override
    public List finUsername() {
        String sql="select username from user ";
        List list=new ArrayList();
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map:maps){
            String username = map.get("username").toString();
            list.add(username);
        }
        return list;
    }

    @Override
    public int findUnDo() {
        String sql="select count(*) from ts where status=0";
        String sql1="select count(*) from fix where status=0";
        String sql2="select count(*) from record where status=0";
        Map<String, Object> map = template.queryForMap(sql);
        Map<String, Object> map1 = template.queryForMap(sql1);
        Map<String, Object> map2 = template.queryForMap(sql2);
        int i = Integer.parseInt(map.get("count(*)").toString());
        int i1 = Integer.parseInt(map1.get("count(*)").toString());
        int i2 = Integer.parseInt(map2.get("count(*)").toString());
        return i+i1+i2;
    }


}
