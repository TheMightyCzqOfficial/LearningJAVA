package abstractTest;

public class Cat extends Animal{
    @Override//继承抽象类必须重写父类所有抽象方法，或定义子类为抽象类
    public void eat() {
        System.out.println("猫吃鱼");
    }
    public void action(){
        System.out.println("猫玩耍");
    }
}
