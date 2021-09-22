package 集合;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<Student>();
        Set<Student> set=new HashSet<>();
        Student stu=new Student();
        stu.setAge(15);
        stu.setName("czq");
        list.add(stu);
        Student s1=new Student("abc",16);
        Student s2=new Student("cde",17);
        list.add(s1);
        list.add(s2);
        set.add(s1);
        set.add(s2);

        Iterator<Student> sit = set.iterator();
        while(sit.hasNext()){
            Student s = sit.next();
            System.out.println(s.getAge()+","+s.getName());
        }

        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student s = it.next();
            System.out.println(s.getAge()+","+ s.getName());
        }
        System.out.println("----------------");
        for (int i=0;i<list.size();i++){
            Student s = list.get(i);
            System.out.println(s.getAge()+","+s.getName());
        }
        System.out.println("----------------");
        for (Student s:list){
           System.out.println(s.getAge()+","+s.getName());
        }
    }


}
