package dao;

import domain.Record;

import java.util.List;

public interface RecordDao {
    public List<Record> findAll();//查询所有缴费记录
    public List<Record> findById(int id);//根据id查询缴费记录
    public void addRecord(Record record);//添加缴费记录
    public void updateRecord(int id);//修改缴费状态
    public List findUserNameAndId();//查询用户名与对应id
    public String findNameById(int id);//根据id查询用户名
    public int findRecordCountByName(String name);//查询未处理的信息
}
