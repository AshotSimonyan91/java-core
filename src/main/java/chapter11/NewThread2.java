package chapter11;

public class NewThread2 implements Runnable{
    String name;
    Thread t;

    public NewThread2(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("new thread: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println(name + " stopped");
        }
        System.out.println(name + " ended");
    }
}
