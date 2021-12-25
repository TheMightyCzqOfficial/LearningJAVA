package dao.impl;

import dao.RecordDao;
import domain.Record;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;

public class RecordDaoImpl implements RecordDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDatasource());
    @Override
    public List<Record> findAll() {
        String sql="select * from record";
        return template.query(sql,new BeanPropertyRowMapper<>(Record.class));
    }

    @Override
    public List<Record> findById(int id) {
        List<Record> query = null;
        try {
            String sql="select * from record where id=?";
            query = template.query(sql, new BeanPropertyRowMapper<>(Record.class),id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public void addRecord(Record record) {
        String name = findNameById(record.getId());
        String sql="insert into record(id,name,text,money,status) value(?,?,?,?,?)";
        template.update(sql,record.getId(),name,record.getText(),record.getMoney()+" 元",record.getStatus());
    }

    @Override
    public void updateRecord(int id) {
        String sql="update record set status=1 where rid=?";
        template.update(sql,id);
    }

    @Override
    public List findUserNameAndId() {
        String sql="select id,name,username from user";
        List<Map<String, Object>> maps = template.queryForList(sql);

        return maps;
    }

    @Override
    public String findNameById(int id) {
        String sql="select username from user where user.id=?";
        Map<String, Object> map = template.queryForMap(sql, id);
        return map.get("username").toString();
    }

    @Override
    public int findRecordCountByName(String name) {
        int i = 0;
        try {
            int id = findIdByName(name);
            String sql="select count(*) from record where status=0 and id=?";
            Map<String, Object> map = template.queryForMap(sql, id);
            i = Integer.parseInt(map.get("count(*)").toString());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return i;
    }

    public int findIdByName(String name) {
        int id = 0;
        try {
            String sql="select id from record where name=?";
            List<Map<String, Object>> maps = template.queryForList(sql, name);
            maps.toArray();
            Map<String, Object> map = maps.get(0);
            id = Integer.parseInt(map.get("id").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
}
