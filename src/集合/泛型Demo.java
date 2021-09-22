package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class 泛型Demo {
    public static void main(String[] args) {
        Collection<String> c=new ArrayList<String>();//限制String类型,泛型的好处是程序不需要加强制类型转换
        c.add("aaa");
        c.add("aaa");
        c.add("aaa");
        c.add("aaa");
        c.add("aaa");
        c.add("aaa");
        c.add("aaa");
        c.add("aaa");
        Iterator<String> it = c.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }

    }
}
