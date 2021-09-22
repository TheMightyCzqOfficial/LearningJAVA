package 集合.成绩排序;

import java.util.Comparator;
import java.util.TreeSet;

public class StudentDemo {
    public static void main(String[] args) {
        Student s1=new Student("czq",99,98);
        Student s2=new Student("czqq",66,88);
        Student s3=new Student("aczq",77,80);
        Student s4=new Student("bczq",59,59);
        Student s5=new Student("cczq",99,98);
        Student s6=new Student("cczqq",98,99);

        TreeSet<Student> tr=new TreeSet<Student>(new Comparator<Student>() {//指定比较器规则
            @Override
            public int compare(Student s1, Student s2) {
               // return 0;
                int num=(s2.getChinese()+s2.getMath())-(s1.getChinese()+s1.getMath());
                int num1=num==0?s1.getName().compareTo(s2.getName()):num;
                return num1;
            }
        });

        tr.add(s1);
        tr.add(s2);
        tr.add(s3);
        tr.add(s4);
        tr.add(s5);
        tr.add(s6);

        for (Student s:tr){
            System.out.println(s.getName()+","+s.getChinese()+","+s.getMath());
        }


    }
}
