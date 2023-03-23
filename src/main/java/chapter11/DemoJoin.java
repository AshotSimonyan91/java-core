package chapter11;

public class DemoJoin {
    public static void main(String[] args) {
        NewThread2 ob1 = new NewThread2("One");
        NewThread2 ob2 = new NewThread2("Two");
        NewThread2 ob3 = new NewThread2("Three");

        System.out.println("thread one started: " + ob1.t.isAlive());
        System.out.println("thread two started: " + ob2.t.isAlive());
        System.out.println("thread three started: " + ob3.t.isAlive());


        try {
            System.out.println("waiting end threads");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e) {
            System.out.println("main thread stopped");
        }

        System.out.println("thread one started: " + ob1.t.isAlive());
        System.out.println("thread two started: " + ob2.t.isAlive());
        System.out.println("thread three started: " + ob3.t.isAlive());
    }
}
