package 文件流;

import java.io.*;

public class 输入输出流 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw=new PrintWriter(new FileWriter("src\\PrintWriter.txt"),true);
        pw.println("123456");
        pw.println("123456");
        pw.println("123456");
        pw.println("123456");
        pw.println("123456");
        pw.println("123456");
        pw.println("123456");

    }
}
