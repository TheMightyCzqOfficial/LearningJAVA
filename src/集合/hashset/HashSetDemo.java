package 集合.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Student> hs=new HashSet<Student>();
        Student s1=new Student("czq",18);
        Student s2=new Student("czqq",18);
        Student s3=new Student("czqqq",18);
        Student s4=new Student("czqqq",18);
        Student s5=new Student("czq",21);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        hs.add(s5);


        for (Student s : hs){
            System.out.println(s.getName()+","+s.getAge());
        }
        System.out.println("---------------------------");
        Iterator<Student> it = hs.iterator();
        while(it.hasNext()){
            Student s = it.next();
            System.out.println(s.getName()+","+s.getAge());
        }

    }
}
