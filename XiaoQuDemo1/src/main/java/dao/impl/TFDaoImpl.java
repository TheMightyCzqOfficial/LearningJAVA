package dao.impl;

import dao.TFDao;
import domain.Fix;
import domain.Ts;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;

public class TFDaoImpl implements TFDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDatasource());
    @Override
    public List<Ts> findAllTs() {
        String sql="select * from ts";
        return template.query(sql,new BeanPropertyRowMapper<>(Ts.class));
    }

    @Override
    public List<Fix> findAllFix() {
        String sql="select * from fix";
        return template.query(sql,new BeanPropertyRowMapper<>(Fix.class));
    }

    @Override
    public void addTs(Ts ts) {
        String sql="insert into ts(ts_user,ts_name,ts_text,status) value(?,?,?,?)";
        template.update(sql,ts.getTs_user(),ts.getTs_name(),ts.getTs_text(),ts.getStatus());
    }

    @Override
    public void addFix(Fix fix) {
        String sql="insert into fix(fix_user,fix_name,fix_text,status) value(?,?,?,?)";
        template.update(sql,fix.getFix_user(),fix.getFix_name(),fix.getFix_text(),fix.getStatus());
    }

    @Override
    public void updateTs(int id) {
        String sql="update ts set status=? where id=?";
        template.update(sql,1,id);
    }

    @Override
    public void updateFix(int id) {
        String sql="update fix set status=? where id=?";
        template.update(sql,1,id);
    }

    @Override
    public List<Ts> findTsByName(String name) {
        String sql="select * from ts where ts_user=?";
        return template.query(sql,new BeanPropertyRowMapper<>(Ts.class),name);

    }

    @Override
    public List<Fix> findFixByName(String name) {
        String sql="select * from fix where fix_user=?";
        return template.query(sql,new BeanPropertyRowMapper<>(Fix.class),name);
    }

    @Override
    public int findTFCountByName(String name) {
        int i = 0;
        int i1 = 0;
        try {
            String sql="select count(*) from fix where fix_user=? and status=0";
            String sql1="select count(*) from ts where ts_user=? and status=0";
            Map<String, Object> map = template.queryForMap(sql, name);
            Map<String, Object> map1 = template.queryForMap(sql1, name);
            i = Integer.parseInt(map.get("count(*)").toString());
            i1 = Integer.parseInt(map1.get("count(*)").toString());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return i+i1;
    }
}
