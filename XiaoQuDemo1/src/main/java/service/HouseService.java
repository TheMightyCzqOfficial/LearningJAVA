package service;

import domain.House;

import java.util.List;

public interface HouseService {
    public List<House> findAll();
    public void addHouse(House house);
    public void deleteHouse(int id);
    public House findHouseById(int id);
    public void updateHouse(House house);
}
