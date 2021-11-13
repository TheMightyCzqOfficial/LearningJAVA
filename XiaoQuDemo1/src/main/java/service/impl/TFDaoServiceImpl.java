package service.impl;

import dao.TFDao;
import dao.impl.TFDaoImpl;
import domain.Fix;
import domain.Ts;
import service.TFDaoService;

import java.util.List;

public class TFDaoServiceImpl implements TFDaoService {
    private TFDao dao=new TFDaoImpl();
    @Override
    public List<Ts> findAllTs() {
        return dao.findAllTs();
    }

    @Override
    public List<Fix> findAllFix() {
        return dao.findAllFix();
    }

    @Override
    public void addTs(Ts ts) {
        dao.addTs(ts);
    }

    @Override
    public void addFix(Fix fix) {
        dao.addFix(fix);
    }

    @Override
    public void updateTs(int id) {
        dao.updateTs(id);
    }

    @Override
    public void updateFix(int id) {
        dao.updateFix(id);
    }

    @Override
    public List<Ts> findTsByName(String name) {
        return dao.findTsByName(name);
    }

    @Override
    public List<Fix> findFixByName(String name) {
        return dao.findFixByName(name);
    }

    @Override
    public int findTFCountByName(String name) {
        return dao.findTFCountByName(name);
    }
}
