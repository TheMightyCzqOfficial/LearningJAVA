package 集合;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> tr = new TreeSet<>();
        tr.add(10);
        tr.add(40);
        tr.add(30);
        tr.add(20);


        tr.add(10);//排序且不重复

        Iterator<Integer> it = tr.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("-------");
        for (int i : tr) {
            System.out.println(i);
        }

    }
}
