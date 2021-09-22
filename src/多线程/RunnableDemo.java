package 多线程;

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable m=new MyRunnable();
        Thread t1=new Thread(m,"thread001:");
        t1.start();
    }
}
