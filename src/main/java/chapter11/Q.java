package chapter11;

public class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("gets: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("puts: " + n);
        notify();
    }
}
