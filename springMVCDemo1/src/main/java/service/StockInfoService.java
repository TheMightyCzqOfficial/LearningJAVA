package service;

import domain.Data;
import domain.StockInfo;

import java.util.List;

public interface StockInfoService {
    public List<StockInfo> findAll(int page,int size);
    public List<Data> findByCode(String code);
    public StockInfo findInfoByCode(String code);
    public String getDataByCode(String code,String start,String end);
    public void addStock(String code);
    public List<StockInfo> searchStock(String info,int code,int page,int size);
}
