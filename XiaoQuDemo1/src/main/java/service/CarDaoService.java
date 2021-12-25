package service;

import domain.Car;

import java.util.List;

public interface CarDaoService {
    public List<Car> findAll();
    public void deleteCar(int id);
    public void addCar(Car car);
    public void updateCar(int id);
    public List<Car> findByUsername(String username);
}
