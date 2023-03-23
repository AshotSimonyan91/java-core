package chapter11;

public class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " enter in method B.bar()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("class B stopped");
        }

        System.out.println(name + "try call method A.last");
        a.last();
    }

    synchronized void last() {
        System.out.println("B in method A.last()");
    }
}
