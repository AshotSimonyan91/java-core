package chapter12;

public class EnumDemo3 {
    public static void main(String[] args) {
        Apple ap;
        System.out.println(Apple.Winesap.getPrice());

        for (Apple a : Apple.values()) {
            System.out.println(a.getPrice());
        }
    }
}
