package File类;


import java.io.FileOutputStream;
import java.io.IOException;

public class 写入txt {
    public static void main(String[] args) throws IOException {
        FileOutputStream f=new FileOutputStream("src/File类/hxhs.txt",true);//true:追加写入
        for (int i =0;i<5000;i++){
            f.write("黄显好Thao".getBytes() );
//            f.write("黄显好帅".getBytes() );
            if (i%5==0){
                f.write("\n".getBytes() );
            }

        }
        System.out.println("succuss!");
        f.close();
    }
}
