package dao;

import domain.Fix;
import domain.Ts;

import java.util.List;

public interface TFDao {
    public List<Ts> findAllTs();//查询所有投诉信息返回管理员端
    public List<Fix> findAllFix();//查询所有报修信息返回管理员端
    public void addTs(Ts ts);//添加投诉
    public void addFix(Fix fix);//添加报修
    public void updateTs(int id);//完成投诉
    public void updateFix(int id);//完成报修
    public List<Ts> findTsByName(String name);//根据用户名查询未处理信息
    public List<Fix> findFixByName(String name);//根据用户名查询未处理信息
    public int findTFCountByName(String name);//根据用户名查询未处理信息数量

}
