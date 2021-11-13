package service.impl;

import dao.HouseDao;
import dao.impl.HouseDaoImpl;
import domain.House;
import service.HouseService;

import java.util.List;

public class HouseServiceImpl implements HouseService {
    private HouseDao hd=new HouseDaoImpl();
    @Override
    public List<House> findAll() {
        return hd.findAll();
    }

    @Override
    public void addHouse(House house) {
        hd.addHouse(house);
    }

    @Override
    public void deleteHouse(int id) {
        hd.deleteHouse(id);
    }

    @Override
    public House findHouseById(int id) {
        return hd.findHouseById(id);
    }

    @Override
    public void updateHouse(House house) {
        hd.updateHouse(house);
    }
}
