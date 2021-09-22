package File类;

import java.io.FileOutputStream;
import java.io.IOException;

public class baocuo {
    public static void main(String[] args) {
        FileOutputStream f=null;
        try {
            f=new FileOutputStream("Z:\\src\\abc.txt");
            f.write(97);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (f!=null){
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
