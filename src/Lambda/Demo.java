package Lambda;

public class Demo {
    public static void main(String[] args) {

        useEatable(a-> System.out.println(a));

        useEatable(System.out::println);

    }
    public static void useEatable(Eatable e){
        e.eat("S");
    }
}
