package chapter11;

public class SuspendResume {
    public static void main(String[] args) {
        NewThread3 ob1 = new NewThread3("One");
        NewThread3 ob2 = new NewThread3("Two");

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("pause thread one");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("resume thread one");
            Thread.sleep(1000);
            ob2.mySuspend();
            System.out.println("pause thread two");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("resume thread two");
        }catch (InterruptedException e) {
            System.out.println("main thread stopped");
        }
        try {
            System.out.println("waiting ended threads");
            ob1.t.join();
            ob2.t.join();
        }catch (InterruptedException e) {
            System.out.println("main thread stopped");
        }
        System.out.println("main thread ended");
    }
}
