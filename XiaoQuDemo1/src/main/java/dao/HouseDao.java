package dao;


import domain.House;

import java.util.List;

public interface HouseDao {
    public List<House> findAll();//查询所有房子信息
    public void addHouse(House house);//添加房间
    public void deleteHouse(int id);//删除房间
    public House findHouseById(int id);//根据id查询房间，预修改
    public void updateHouse(House house);//修改房间信息
}
