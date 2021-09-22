package 生产者消费者;

public class Box {
    private int milk=0;
    private boolean state=false;

    public synchronized void  put(int milk) throws InterruptedException {

        if (state){
            wait();
        }
        this.milk=milk;
        System.out.println("送奶工把第"+this.milk+"瓶奶放入奶箱子");
        state=true;
        notifyAll();
    }
    public synchronized void get(){

        if(!state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("用户取走第"+this.milk+"瓶奶");
        state=false;
        notifyAll();
    }
}
