package first;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 异常 {
    public static void main(String[] args) {
        System.out.println("start");
         method2();
        System.out.println("end");
    }
    public static void method(){
        int arr[]={1,2,3};
        try {
            System.out.println(arr[3]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());
            e.printStackTrace();
        };
    }
    public static void method2(){
        String s="2021-8-27";
        SimpleDateFormat spd=new SimpleDateFormat();
        try {
            Date d = spd.parse(s);
            System.out.println(d);
        }catch (ParseException e){
            e.printStackTrace();
        }



    }
}
