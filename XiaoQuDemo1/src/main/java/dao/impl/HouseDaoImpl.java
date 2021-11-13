package dao.impl;

import dao.HouseDao;
import domain.House;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class HouseDaoImpl implements HouseDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDatasource());
    @Override
    public List<House> findAll() {
        String sql="select * from room";

        return template.query(sql,new BeanPropertyRowMapper<>(House.class));
    }

    @Override
    public void addHouse(House house) {
        String sql="insert into room(house_number,room_number,size) value(?,?,?)";
        template.update(sql,house.getHouse_number(),house.getRoom_number(),house.getSize());
    }

    @Override
    public void deleteHouse(int id) {
        String sql="delete from room where id=?";
        template.update(sql,id);
    }

    @Override
    public House findHouseById(int id) {
        String sql="select * from room where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(House.class),id);
    }

    @Override
    public void updateHouse(House house) {
        String sql="update room set house_number=?,room_number=?,size=? where id=?";
        template.update(sql,house.getHouse_number(),house.getRoom_number(),house.getSize(),house.getId());
    }
}
