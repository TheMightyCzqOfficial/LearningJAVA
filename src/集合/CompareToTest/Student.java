package 集合.CompareToTest;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {
        int num=this.age-s.age;
        Comparator<Object> com = Collator.getInstance(Locale.CHINA);//比较中文
        int numz=num==0?((Collator) com).compare(this.name,s.name):num;
        //int num1=num==0?this.name.compareTo(s.name):num;//若年龄相同按照姓名的字母顺序排序  String类实现了Comparable接口因此可以直接调用
        return numz;
        //return 0;//0代表重复 1代表正序 -1代表降序
    }

}
