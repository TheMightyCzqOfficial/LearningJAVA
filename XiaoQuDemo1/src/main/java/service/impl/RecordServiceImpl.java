package service.impl;

import dao.RecordDao;
import dao.impl.RecordDaoImpl;
import domain.Record;
import service.RecordService;

import java.util.List;

public class RecordServiceImpl implements RecordService {
    private RecordDao dao=new RecordDaoImpl();
    @Override
    public List<Record> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Record> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void addRecord(Record record) {
        dao.addRecord(record);
    }

    @Override
    public void updateRecord(int id) {
        dao.updateRecord(id);
    }

    @Override
    public List findUserNameAndId() {
        return dao.findUserNameAndId();
    }

    @Override
    public int findRecordCountByName(String name) {
        return dao.findRecordCountByName(name);
    }


}
