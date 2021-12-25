package dao.impl;

import dao.CarDao;
import domain.Car;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class CarDaoImpl implements CarDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDatasource());
    @Override
    public List<Car> findAll() {
        String sql="select * from car";
        List<Car> query = template.query(sql, new BeanPropertyRowMapper<Car>(Car.class));
        return query;
    }

    @Override
    public void deleteCar(int id) {
        String sql="delete from car where id=?";
        template.update(sql,id);
    }

    @Override
    public void addCar(Car car) {
        String sql="insert into car(username,type,car_number,end_time) value(?,?,?,?) ";
        template.update(sql,car.getUsername(),car.getType(),car.getCar_number(),car.getEnd_time());
    }

    @Override
    public void updateCar(int id) {//延期一年
        String sql= "update car set end_time= DATE_ADD(end_time,INTERVAL 1 year) where id=?";
        template.update(sql,id);
    }

    @Override
    public List<Car> findByUsername(String username) {
        String sql="select * from car where username=?";
        List<Car> query = template.query(sql, new BeanPropertyRowMapper<Car>(Car.class),username);
        return query;
    }

}
