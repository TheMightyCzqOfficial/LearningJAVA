package first;

import java.util.Scanner;

public class 字符串相关 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(reverse(s));
    }
    public static String reverse(String s){
        String s1="";
        for (int i =s.length()-1;i>=0;i--){
            s1+=s.charAt(i);
        }
        return s1;
    }
}
