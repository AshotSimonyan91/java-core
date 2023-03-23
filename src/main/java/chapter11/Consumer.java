package chapter11;

public class Consumer implements Runnable{
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this,"consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}
