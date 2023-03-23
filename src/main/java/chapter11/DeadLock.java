package chapter11;

public class DeadLock implements Runnable{
    A a = new A();
    B b = new B();

    public DeadLock() {
        Thread.currentThread().setName("main Thread");
        Thread t = new Thread(this,"opposite Thread");
        t.start();

        a.foo(b);
        System.out.println("return to main Thread");
    }

    @Override
    public void run() {
        b.bar(a);
        System.out.println("return to other Thread");
    }

    public static void main(String[] args) {
        new DeadLock();
    }
}
