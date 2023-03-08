package chapter12;

public class EnumDemo2 {
    public static void main(String[] args) {
        Apple ap;
        Apple allApples[] = Apple.values();
        for (Apple allApple : allApples) {
            System.out.println(allApple);
        }

        System.out.println();
        ap = Apple.valueOf("Winesap");
        System.out.println(ap);
    }
}
