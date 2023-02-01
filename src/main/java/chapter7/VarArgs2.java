package chapter7;

public class VarArgs2 {
    static void vaTest(String msg, int... v) {
        System.out.println(msg + v.length);
        for (int x : v) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest("One parameters ", 10);
        vaTest("Three parameters ",1,2,3);
        vaTest("Zero parameters ");
    }
}
