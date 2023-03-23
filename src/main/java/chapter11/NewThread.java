package chapter11;

public class NewThread implements Runnable{
    Thread t;

    public NewThread() {
        t = new Thread(this,"demonstrate thread");
        System.out.println("daughter thread created: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("daughter thread: " + i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("daughter thread stopped");
        }
        System.out.println("daughter thread ended");
    }
}
