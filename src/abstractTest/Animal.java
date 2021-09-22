package abstractTest;

public abstract class Animal {
    private int age;
    private String name;
    public Animal(){

    }
    public abstract void eat();//抽象方法

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
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
    public void show(){
        System.out.println(this.age+","+this.name);
    }
}
