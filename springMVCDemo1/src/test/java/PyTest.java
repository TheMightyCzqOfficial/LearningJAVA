import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PyTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Process proc;
        try {
            String[] args1 = new String[] { "C:\\Users\\CZQ\\PycharmProjects\\PythonDemo\\venv\\Scripts\\python.exe",
                    "C:\\Users\\CZQ\\PycharmProjects\\PythonDemo\\7\\stockDemo1\\main.py",
                    "000001","20211212","20211221"};//python.exe处为你系统中python的安装位置；python.py为想要执行的python文件位置；test为想要传的参数
            //proc = Runtime.getRuntime().exec("python.exe python.py ");// 执行py文件 不传参数
            proc=Runtime.getRuntime().exec(args1);
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
            String line = null;
            System.out.println("========");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();

            proc.waitFor();
            System.out.println("成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
