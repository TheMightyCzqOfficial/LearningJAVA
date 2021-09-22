package 集合.成绩排序;

public class Student {
    private String name;
    private int Chinese;
    private int Math;

    public Student(String name, int chinese, int math) {
        this.name = name;
        Chinese = chinese;
        Math = math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }
}
