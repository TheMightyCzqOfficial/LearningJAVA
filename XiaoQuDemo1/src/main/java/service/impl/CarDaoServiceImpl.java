package service.impl;

import dao.CarDao;
import dao.impl.CarDaoImpl;
import domain.Car;
import service.CarDaoService;

import java.util.List;

public class CarDaoServiceImpl implements CarDaoService {
    private CarDao dao=new CarDaoImpl();
    @Override
    public List<Car> findAll() {
        return dao.findAll();
    }

    @Override
    public void deleteCar(int id) {
        dao.deleteCar(id);
    }

    @Override
    public void addCar(Car car) {
        dao.addCar(car);
    }

    @Override
    public void updateCar(int id) {
        dao.updateCar(id);
    }

    @Override
    public List<Car> findByUsername(String username) {
        return dao.findByUsername(username);
    }
}
