package dao;

import domain.Data;
import domain.StockInfo;

import java.util.HashMap;
import java.util.List;

public interface StockInfoMapper {

    public List<StockInfo> findAll();

    public List<Data> findByCode(String code);

    public StockInfo findInfoByCode(String code);

    public List<StockInfo> searchStock(HashMap<String,Object> map);

}
