package service;

import domain.Record;

import java.util.List;

public interface RecordService {
    public List<Record> findAll();
    public List<Record> findById(int id);
    public void addRecord(Record record);
    public void updateRecord(int id);
    public List findUserNameAndId();
    public int findRecordCountByName(String name);
}
