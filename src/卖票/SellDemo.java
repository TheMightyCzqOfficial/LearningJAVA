package 卖票;

public class SellDemo {
    public static void main(String[] args) {
        SellTicket st=new SellTicket();
        Thread t1=new Thread(st);
        Thread t2=new Thread(st);
        Thread t3=new Thread(st);
        t1.setName("1号窗口");
        t2.setName("2号窗口");
        t3.setName("3号窗口");
        t1.start();
        t2.start();
        t3.start();
    }
}
