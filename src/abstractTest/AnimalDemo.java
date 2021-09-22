package abstractTest;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal a=new Cat();//多态，向上转型
        Animal b= new Dog();

        a.setAge(10);
        a.setName("暹罗猫");
        a.eat();
        //向下转型，调用子类独有方法
        Cat c=(Cat) a;
        c.action();
        a.show();

        b.setAge(10);
        b.setName("沙皮狗");
        b.eat();
        //向下转型，调用子类独有方法
        Dog d=(Dog) b;
        d.action();
        b.show();
    }
}
