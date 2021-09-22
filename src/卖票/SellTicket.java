package 卖票;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicket implements Runnable{
    private int ticket=100;
    private Object oo=new Object();
    private Lock lock=new ReentrantLock();
    @Override
    public void run() {


            for (; ; ) {
               // synchronized (oo) {//this//类名.class //当t1执行这段代码以后，就会将这段代码锁起来//使用同一个对象oo
                    //好处：解决了多线程同步数据的安全问题
                    //弊端：每次需要判断线程是否在执行，很耗费资源，降低程序的运行效率
                try{

                lock.lock();
                if (ticket <= 0) {
                    System.out.println("票已售罄！");
                } else {

                    System.out.println(Thread.currentThread().getName() + ": " + "成功售出第" + ticket + "张");
                    ticket--;

                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
                finally{

                    lock.unlock();
                }

            }
        }

    }
//}
