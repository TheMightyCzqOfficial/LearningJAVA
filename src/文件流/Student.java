package 文件流;

public class Student {
    private int age;
    private  String name;
    private String sid;

    public Student(int age, String name, String sid) {
        this.age = age;
        this.name = name;
        this.sid = sid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
