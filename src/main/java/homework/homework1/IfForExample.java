package homework.homework1;

public class IfForExample {

    public static void main(String[] args) {
        int a = 34;
        int b = 77;

        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }


        for (int i = a; i <= b; i++) {
            System.out.print(i + ",");
        }
        System.out.println();


        System.out.println("a to char- " + ((char) a) + "\nb to char- " + (char) b);

        if (a == b) {
            System.out.println("a = b");
        } else {
            System.out.println("a != b");
        }


    }
}
