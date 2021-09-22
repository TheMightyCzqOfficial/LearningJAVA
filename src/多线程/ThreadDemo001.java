package 多线程;

public class ThreadDemo001{
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread001();
        Thread t2=new Thread001();
        Thread.currentThread().setName("main");
        t1.setName("T1:");
        t2.setName("T2:");
//        t1.setPriority(1);//优先级高表示获取cpu的时间片纪律高，并不表示执行顺序
//        t2.setPriority(10);
        t1.setDaemon(true);
        t2.setDaemon(true);//设置守护进程 当主线程结束时/运行的线程都是守护线程的时候Java虚拟机退出
        t2.start();
        t2.join();//设置执行先后顺序 当join先执行完毕才会继续执行其他线程
        t1.start();
        for (int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

}
