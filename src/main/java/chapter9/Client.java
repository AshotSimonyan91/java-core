package chapter9;

public class Client implements Callback{
    @Override
    public void callback(int p) {
        System.out.println("method Callback with argument " + p);
    }

    void nonIFaceMeth() {
        System.out.println("another method in class implements Callback");
    }
}
