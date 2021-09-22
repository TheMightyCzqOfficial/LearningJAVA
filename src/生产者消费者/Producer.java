package 生产者消费者;

public class Producer implements Runnable{
    private Box b;

    public Producer(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i=1;i<11;i++){
            try {
                b.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
