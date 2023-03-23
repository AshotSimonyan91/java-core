package chapter11;

public class Caller implements Runnable {
    String msg;
    CallMe target;
    Thread t;

    public Caller(CallMe target, String msg) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}
