package 泛型;

public class Demo {
    public static void main(String[] args) {
        /*Generic<String> g=new Generic<String>();
        g.setT("aab cvdva");
        System.out.println(g.getT());

        Generic<Integer> g1=new Generic<Integer>();
        g1.setT(123456789);
        System.out.println(g1.getT());*/
        fanxingImpl fx=new fanxingImpl();
        Generic g = new Generic();
        g.show(123);
        g.show("abc");
        g.show(true);
        g.show(12.34);
        System.out.println("--------------");
        fx.show(123);
        fx.show("abcvdasdsad");
    }
}
