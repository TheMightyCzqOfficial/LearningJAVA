package studentDemo反射;

import java.util.ArrayList;

public class StudentArrayList {
    public static void main(String[] args) {
        ArrayList<Student> arr=new ArrayList<Student>();

        Student s1=new Student("aa",30);
        Student s2=new Student("bb",31);
        Student s3=new Student("cc",32);

        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        System.out.println(s1);
        for (int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
            Student s = arr.get(i);
            System.out.println(s.getName()+","+s.getAge());

        }

    }
}
