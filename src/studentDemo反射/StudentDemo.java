package studentDemo反射;

import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        Student stu=new Student();
        stu.study();
        stu.doHomework();
        stu.setAge(18);
        stu.setName("czq");
        stu.show();
        System.out.println(stu.toString());
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        System.out.println(line);

    }



}
