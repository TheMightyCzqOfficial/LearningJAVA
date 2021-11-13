package dao;

import domain.Record;

import java.util.List;

public interface RecordDao {
    public List<Record> findAll();
    public List<Record> findById(int id);
    public void addRecord(Record record);
    public void updateRecord(int id);
    public List findUserNameAndId();
    public String findNameById(int id);
    public int findRecordCountByName(String name);
}
