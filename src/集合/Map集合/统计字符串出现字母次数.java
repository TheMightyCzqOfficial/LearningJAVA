package 集合.Map集合;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class 统计字符串出现字母次数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串: ");
        String line = sc.nextLine();
        HashMap<Character,Integer> hm=new HashMap<>();

        for (int i=0;i<line.length();i++){
            int value=1;
            char key = line.charAt(i);
            System.out.println(key);
            if(hm.containsKey(key)==false){
                hm.put(key,value);
            }
            else {
                int value1 = hm.get(key);
                hm.remove(key);
                value1+=1;
                hm.put(key,value1);
            }
        }
        System.out.println("输入了："+line+"共有 "+line.length()+" 个字母");//也可以使用StringBuilder拼接
        Set<Character> keySet = hm.keySet();
        for(Character c:keySet){
            Integer integer = hm.get(c);
            System.out.print(c+"("+integer+")");
        }

    }
}
