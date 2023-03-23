package chapter11;

public class NewThread3 implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    public NewThread3(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("new thread " + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " stopped");
        }
        System.out.println(name + " ended");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }
}
