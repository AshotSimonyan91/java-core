package chapter9;

public class AnotherClient implements Callback{

    @Override
    public void callback(int p) {
        System.out.println("onr more variant callback method");
        System.out.println("p square equals " + (p * p));
    }
}
