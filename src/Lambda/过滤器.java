package Lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class 过滤器 {
    public static void main(String[] args) {
        String[] strArray={"aa,20","ddd,30","hxhs,50"};

        ArrayList<String> arr=filter(strArray,s->s.split(",")[0].length()>2,s -> Integer.parseInt(s.split(",")[1])>33);

        for (String s:arr){
            System.out.println(s);
        }
    }
    private static ArrayList<String> filter(String[] strArray, Predicate<String> pre1,Predicate<String> pre2){
        ArrayList<String> arr=new ArrayList<>();
        for (String s:strArray){
            if(pre1.and(pre2).test(s)){
                arr.add(s);
            }
        }
        return arr;
    }
}
