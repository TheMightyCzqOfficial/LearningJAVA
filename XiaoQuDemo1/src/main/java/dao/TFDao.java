package dao;

import domain.Fix;
import domain.Ts;

import java.util.List;

public interface TFDao {
    public List<Ts> findAllTs();
    public List<Fix> findAllFix();
    public void addTs(Ts ts);
    public void addFix(Fix fix);
    public void updateTs(int id);
    public void updateFix(int id);
    public List<Ts> findTsByName(String name);
    public List<Fix> findFixByName(String name);
    public int findTFCountByName(String name);

}
