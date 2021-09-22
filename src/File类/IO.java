package File类;

import java.io.FileOutputStream;
import java.io.IOException;

public class IO {
    public static void main(String[] args) throws IOException {
        FileOutputStream f=new FileOutputStream("src/File类/zijieliu.txt");
        byte[] b= {97, 98, 99, 100, 101};
//        for (byte a:b){
//            f.write(a);
//        }
        byte[] bytes = "2021年9月16日臭猫咬断了我的耳机线！".getBytes();
        for (byte hxhs:bytes){
            System.out.println(hxhs);
        }
        f.write(bytes);
        f.close();

    }
}
