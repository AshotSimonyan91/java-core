package chapter11;

public class NewThread1 extends Thread {
    NewThread1() {
        super("demonstrate thread");
        System.out.println("daughter thread: " + this);
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("daughter thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("daughter thread stopped");
        }
        System.out.println("daughter thread ended");
    }
}
