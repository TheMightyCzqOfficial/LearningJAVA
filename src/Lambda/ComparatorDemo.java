package Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<String>();
        arr.add("a");
        arr.add("aa");
        arr.add("aaa");
        arr.add("aaaa");
        arr.add("aaaaa");
        Collections.sort(arr,getComparator());
        System.out.println(arr);
    }
    private static Comparator<String> getComparator(){
        return (s1,s2)->s2.length()-s1.length();
    }
}
