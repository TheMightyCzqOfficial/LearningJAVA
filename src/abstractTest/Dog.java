package abstractTest;

public  class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
    public void action(){
        System.out.println("狗玩耍");
    }
}
