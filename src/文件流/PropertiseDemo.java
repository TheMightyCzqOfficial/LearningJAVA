package 文件流;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiseDemo  {
    public static void main(String[] args) throws IOException {
        Properties pro=new Properties();
        pro.setProperty("001","aaaaaa");
        pro.setProperty("002","bbbb");
        FileWriter fw=new FileWriter("src\\pros.txt");
        pro.store(fw,null);
        fw.close();
    }
}
