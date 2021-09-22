package InterF;

public class Demo {
    public static void main(String[] args) {
        Interface i=new Cat();
        i.Jump();

        Animal a=new Cat();

        a.setAge(10);
        a.setName("aaa");
        a.show();

    }
}
