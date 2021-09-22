package first;

import java.util.Calendar;
import java.util.Scanner;

public class 二月天 {
    public static void main(String[] args) {
        int year;
        Scanner sc=new Scanner(System.in);
        System.out.println("输入年份");
        year=sc.nextInt();

        Calendar c = Calendar.getInstance();
        c.set(year,2,1);//月份从0开始
        c.add(Calendar.DATE,-1);


        //获取get
        int date = c.get(Calendar.DATE);
        System.out.println(date);

    }
}
