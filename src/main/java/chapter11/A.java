package chapter11;

public class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " enter in method A.foo()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("class A stopped");
        }
        System.out.println(name + " trying call method B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("B in method A.last()");
    }
}
