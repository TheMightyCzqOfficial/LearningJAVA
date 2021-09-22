package File类;

import java.io.File;
import java.io.IOException;

public class 创建 {
    public static void main(String[] args) throws IOException {
        File f1=new File("C:\\Users\\CZQ\\Desktop");//同一个目录文件名不能与目录名相同
        System.out.println(f1.createNewFile());
        File f2=new File("C:\\Users\\CZQ\\Desktop\\Java文件\\目录");
        System.out.println(f2.mkdir());
        File f3=new File("C:\\Users\\CZQ\\Desktop\\Java文件\\目录\\z");
        System.out.println(f3.mkdirs());
        String[] str=f1.list();
        for (String s:str){
            System.out.println(s);
        }
    }
}
