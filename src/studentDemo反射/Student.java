package studentDemo反射;

public class Student {
    private String name;
    private int age;
    private int id;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {

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

    public void doHomework() {
        System.out.println("做作业");
    }

    public void study() {
        System.out.println("学习");
    }
    public String caishu(String s,int i,double d) {
        System.out.println(s+i+d);
        return s+i+d;
    }
    private void study1(int i) {

        System.out.println("学习 private 第"+i+"天");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show() {
        System.out.println(name + "," + age);
    }
}
