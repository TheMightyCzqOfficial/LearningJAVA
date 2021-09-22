package File类;

import java.io.*;

public class read {
    public static void main(String[] args) throws IOException {
//        FileInputStream f=new FileInputStream("C:\\Users\\CZQ\\IdeaProjects\\first project\\src\\File类\\hxhs.txt");
//        InputStreamReader isr=new InputStreamReader(new FileInputStream("C:\\Users\\CZQ\\IdeaProjects\\first project\\src\\File类\\hxhs.txt"),"UTF-8");
//        int b= isr.read();
//        while(b!=-1){
//            System.out.print((char)b);
//            b=isr.read();
//        }
        long st=System.currentTimeMillis();
        BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\CZQ\\IdeaProjects\\first project\\src\\File类\\hxhs.txt"));
        char[] ch=new char[20000];
       // int len;
//        while(br.read(ch)!=-1){
//            System.out.println(ch);
//        }
        String s;
        while((s=br.readLine())!=null){
            System.out.println(s);
        }
        br.close();
        long et=System.currentTimeMillis();
        System.out.println(et-st+" ms");
    }
}
