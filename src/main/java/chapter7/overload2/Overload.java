package chapter7.overload2;

public class Overload {
    void test() {
        System.out.println("Empty");
    }

    void test(int a, int b) {
        System.out.println("a & b: " + a + " " + b);
    }

    void test(double a) {
        System.out.println("double a: " + a);
    }
}
