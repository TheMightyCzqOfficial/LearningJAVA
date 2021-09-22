package 可变参数;

import java.util.ArrayList;
import java.util.List;

public class numbers {
    public static void main(String[] args) {
        System.out.println(sum(1,2,3,4,5,6,7,89,987,987,987,54654,231,12));
        List<?extends Number> list=new ArrayList<Integer>();//通配符上限为Number
    }
    public static int sum(int ...a){
        int sum=0;
        for (int i:a){
            sum+=i;
        }
        return sum;
    }
}
