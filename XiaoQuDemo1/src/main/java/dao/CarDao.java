package dao;

import domain.Car;

import java.util.*;

public interface CarDao {
    public List<Car> findAll();//查询所有车辆信息
    public void deleteCar(int id);//删除车辆
    public void addCar(Car car);//添加车辆
    public void updateCar(int id);//延长车辆到期时间
    public List<Car> findByUsername(String username);//根据用户名查询车辆信息

    public static void main(String[] args) {
        int a ;
        int c = 0;
        StringBuilder b =new StringBuilder();
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b.append(a).reverse();
        char c1 = b.charAt(b.length()-1);
        if (c1=='-'){
            b.deleteCharAt(b.length()-1);
            c=Integer.parseInt(b.toString());
            System.out.println("-"+c);
        }else{
            c=Integer.parseInt(b.toString());
            System.out.println(c);
        }
    }
}
