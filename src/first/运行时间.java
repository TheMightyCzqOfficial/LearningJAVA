package first;

public class 运行时间 {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            System.out.println(i);
        }
        long end=System.currentTimeMillis();
        System.out.println("运行时间为： "+(end-start)+"毫秒");
    }
}
