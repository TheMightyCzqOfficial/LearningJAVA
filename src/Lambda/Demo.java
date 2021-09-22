package Lambda;

public class Demo {
    public static void main(String[] args) {
        EatableImpl eat=new EatableImpl();
        eat.eat();

        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("eat");
            }
        });

        useEatable(()-> {
            System.out.println("chichichi");
        });

    }
    public static void useEatable(Eatable e){
        e.eat();
    }
}
