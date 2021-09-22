package 文件流;

import java.io.*;

public class copyFile多级 {
    public static void main(String[] args) throws IOException{
        File src=new File("D:\\JavaFile123");
        String name = src.getName();
        File dest=new File("C:\\Users\\CZQ\\IdeaProjects\\first project\\src",name);
        Directory(src,dest);

    }
    public static void Directory(File src,File dest) throws IOException{
        if (!dest.exists()){
            dest.mkdir();
        }
        File[] files = src.listFiles();
        for (File srcF:files){
           System.out.println(srcF.getName());

            if (srcF.isDirectory()){
                String srcFName = srcF.getName();
                //File src1=new File(srcF,srcFName);
                File dest1=new File(dest,srcFName);
                if (!dest1.exists()){
                    dest1.mkdir();
                }
                Directory(srcF,dest1);
            }
            else{
                String name1 = srcF.getName();
                File destFile=new File(dest,name1);//文件夹内的文件名称要一致
                copyFileMethod(srcF,destFile);
            }

        }
    }
    private static void copyFileMethod(File src, File destFile) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] b=new byte[1024];
        int len;
        while((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }

        System.out.println("success!");
    }

}
