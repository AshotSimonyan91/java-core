package chapter7;

public class VarArgs3 {
    static void vaTest(int ... v) {
        System.out.println(v.length);
        for (int x : v) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    static void vaTest(boolean ... v) {
        System.out.println(v.length);
        for (boolean x : v) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    static void vaTest(String msg,int ... v) {
        System.out.println(msg + v.length);
        for (int x : v) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest(1,2,3);
         vaTest("Test",10,20);
         vaTest(true,false,false);
    }
}
