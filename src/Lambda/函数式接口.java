package Lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class 函数式接口 {
    public static void main(String[] args) {
        String string = getString(() -> "aaaaaa");
        System.out.println(string);
        operatorString("jjj", System.out::println);//方法引用
        operatorString("abcde",s-> System.out.println(new StringBuilder(s).reverse()));//传入的字符串，对字符串的消费（操作）
        System.out.println("------------------");

        operatorString("twice",s -> System.out.println(s),s -> System.out.println(new StringBuilder(s).reverse()));
    }
    private static String getString(Supplier<String> sup){
        return sup.get();
    }
    private static void operatorString(String s,Consumer<String> con){//消费型接口consumer对字符串进行操作
        con.accept(s);
    }
    private static void operatorString(String s,Consumer<String> con1,Consumer<String> con2){//消费型接口consumer对字符串进行操作
        con1.andThen(con2).accept(s);//对同一个字符串消费两次
    }
}
