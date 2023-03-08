package chapter10;

public class ThrowsDemo {
    static void throwOne () throws IllegalAccessException {
        System.out.println("in method throwOne()");
        throw new IllegalAccessException("demonstration");
    }

    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
    }
}
