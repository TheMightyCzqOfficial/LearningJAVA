package 文件流;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class write {
    public static void main(String[] args) throws IOException {
        Student stu1=new Student(18,"lgy","001");
        Student stu2=new Student(19,"hx","002");
        Student stu3=new Student(20,"hbk","003");
        Student stu4=new Student(21,"czq","004");
        ArrayList<Student> arr=new ArrayList<>();
        arr.add(stu1);
        arr.add(stu2);
        arr.add(stu3);
        arr.add(stu4);
        BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\CZQ\\IdeaProjects\\first project\\student.txt"));
        for (Student s:arr){
            StringBuilder sb=new StringBuilder();
            sb.append(s.getAge()).append(",").append(s.getName()).append(",").append(s.getSid());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
