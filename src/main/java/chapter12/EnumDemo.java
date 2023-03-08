package chapter12;

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap;
        ap = Apple.RedDel;
        System.out.println(ap);
        System.out.println();

        ap = Apple.GoldenDel;

        if (ap == Apple.GoldenDel) {
            System.out.println(ap);
        }

        switch (ap) {
            case Jonathan -> System.out.println("Jonathan");
            case GoldenDel -> System.out.println("GoldenDel");
            case RedDel -> System.out.println("RedDel");
            case Winesap -> System.out.println("Winesap");
            case Cortland -> System.out.println("Cortland");
        }
    }
}
