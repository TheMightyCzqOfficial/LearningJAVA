package File类;

import java.io.*;

public class pic {
    public static void main(String[] args) throws IOException {

        long st=System.currentTimeMillis();
        //method1();
        //method2();
        //method3();
        method4();//5ms最快
        long et=System.currentTimeMillis();
        System.out.println(et-st+" ms");
        System.out.println("success!");

    }
    public static void method1() throws IOException{
        FileInputStream fis=new FileInputStream("C:\\Users\\CZQ\\Desktop\\catshit.jpg");
        FileOutputStream fos=new FileOutputStream("src/File类/hxhs.jpg");
        int b= fis.read();
        while(b!=-1){//一次一字节
            fos.write(b);
            b=fis.read();
        }
        fos.close();
        fis.close();
    }
    public static void method2() throws IOException{
        FileInputStream fis=new FileInputStream("C:\\Users\\CZQ\\Desktop\\catshit.jpg");
        FileOutputStream fos=new FileOutputStream("src/File类/hxhs.jpg");
        byte[] b=new byte[1024];//一次一字节数组
        int len;
        while((len=fis.read(b))!=-1){//一次一字节
            fos.write(b,0,len);

        }
        fos.close();
        fis.close();
    }
    public static void method3() throws IOException{
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("C:\\Users\\CZQ\\Desktop\\catshit.jpg"));
        // FileInputStream fis=new FileInputStream("C:\\Users\\CZQ\\Desktop\\catshit.jpg");
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("src/File类/hxhs.jpg"));
        //FileOutputStream fos=new FileOutputStream("src/File类/hxhs.jpg");

        int b=bis.read();
        while(b!=-1){//一次一字节
            bos.write(b);
            b=bis.read();

        }
        bos.close();
        bis.close();
    }
    public static void method4() throws IOException{
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("C:\\Users\\CZQ\\Desktop\\catshit.jpg"));
       // FileInputStream fis=new FileInputStream("C:\\Users\\CZQ\\Desktop\\catshit.jpg");
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("src/File类/hxhs.jpg"));
        //FileOutputStream fos=new FileOutputStream("src/File类/hxhs.jpg");
        byte[] b=new byte[1024];//一次一字节数组
        int len;
        while((len=bis.read(b))!=-1){//一次一字节 len=-1时代表文件读写结束，
            bos.write(b,0,len);

        }
        bos.close();
        bis.close();
    }
}
