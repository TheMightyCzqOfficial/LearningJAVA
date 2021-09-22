package InterF;



public class Cat extends Animal implements Interface{
    public Cat() {
    }

    public Cat(int age, String name) {
        super(age, name);
    }

    @Override//继承抽象类必须重写父类所有抽象方法，或定义子类为抽象类
    public void eat() {
        System.out.println("猫吃鱼");
    }
    /*public void action(){
        System.out.println("猫玩耍");
    }*/

    @Override
    public void Jump() {
        System.out.println("猫跳高");
    }
    public void Sleep(){

    }
}
