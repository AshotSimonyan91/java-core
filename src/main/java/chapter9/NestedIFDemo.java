package chapter9;

public class NestedIFDemo {
    public static void main(String[] args) {
        A.NestedIF nif = new B();

        if (nif.isNotNegative(10)){
            System.out.println("10 is positive");
        }
        if (nif.isNotNegative(-12)){
            System.out.println("it doesn't print");
        }
    }
}
