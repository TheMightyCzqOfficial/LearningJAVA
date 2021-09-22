package 集合.CompareToTest;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Student> tr=new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //return 0;
                int num=s1.getAge()-s2.getAge();
                int num1=num==0?s1.getName().compareTo(s2.getName()):num;
                return num1;
            }
        });//创建对象时指定比较器规则
        Student s1=new Student("啊",18);
        Student s2=new Student("czqq",17);
        Student s3=new Student("czqqq",16);
        Student s4=new Student("czqqq",16);
        Student s5=new Student("吧啊",18);

        tr.add(s1);
        tr.add(s2);
        tr.add(s3);
        tr.add(s4);
        tr.add(s5);

        for (Student s:tr){
            System.out.println(s.getName()+","+s.getAge());
        }


    }
}
