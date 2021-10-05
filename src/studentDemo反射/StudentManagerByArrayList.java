package studentDemo反射;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagerByArrayList {
    public static void main(String[] args) {
        int options;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> array = new ArrayList<Student>();
        StringBuilder sb=new StringBuilder();
        for (int j=0;j<7;j++){
            sb.append("厉泽宇超级帅");
            System.out.println(sb);
        }
        System.out.println("-----------欢迎来到学生管理系统-----------");
        do {
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查看学生列表");
            System.out.println("5:退出系统");
            options = sc.nextInt();
            switch (options) {
                case (1): {
                    System.out.println("添加学生:");
                    addStudent(array);
                    break;
                }
                case (2): {
                    System.out.println("删除学生:");
                    removeStudent(array);
                    break;
                }
                case (3): {
                    System.out.println("修改学生:");
                    updateStudent(array);
                    break;
                }
                case (4): {
                    System.out.println("学生列表:");
                    getStudent(array);
                    break;
                }
                case 5: {
                    System.out.println("退出成功！");
                    break;
                }
                default: {
                    System.out.println("输入有误请重新输入！");
                    break;
                }
            }
        } while (options != 5);


    }

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        System.out.println("请输入学生学号:");
        int id = sc.nextInt();

        //学号查重
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //System.out.println(s);
            if (id == s.getId()) {
                System.out.println("学号重复请重新输入！");
                addStudent(array);
                return;
            }
        }

        stu.setId(id);
        sc.nextLine();//刷新缓冲区 取走回车符
        System.out.println("请输入学生姓名:");
        String name = sc.nextLine();
        stu.setName(name);
        System.out.println("请输入学生年龄:");
        stu.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("请输入学生居住地:");
        stu.setAddress(sc.nextLine());
        System.out.println("添加成功");
        array.add(stu);

    }

    public static void removeStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生学号：");
        getStudent(array);
        int id = sc.nextInt();
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (id == s.getId()) {
                array.remove(i);
            }
        }
        System.out.println("删除成功");
        getStudent(array);
    }

    public static void getStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("未查询到学生记录，请输入学生信息！");
            return;
        }
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //System.out.println(s);
            System.out.println("学号:" + s.getId() + "  名字:" + s.getName() + "  年龄:" + s.getAge() + "  住址:" + s.getAddress());
        }
    }

    public static void updateStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        System.out.println("请输入你要修改的学生学号：");
        getStudent(array);
        int id = sc.nextInt();
        stu.setId(id);
        sc.nextLine();
        System.out.println("请输入学生姓名:");
        stu.setName(sc.nextLine());
        System.out.println("请输入学生年龄:");
        stu.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("请输入学生居住地:");
        stu.setAddress(sc.nextLine());
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (id == s.getId()) {
                array.set(i, stu);
            }

        }
        System.out.println("修改成功");
        getStudent(array);
    }
}
