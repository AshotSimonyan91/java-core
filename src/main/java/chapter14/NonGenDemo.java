package chapter14;

public class NonGenDemo {
    public static void main(String[] args) {
        NonGen iOb;
        iOb = new NonGen(88);
        iOb.showType();

        int v = (Integer) iOb.getOb();
        System.out.println(v);
        System.out.println();

        NonGen strOb = new NonGen("Test");

        strOb.showType();
        String str = (String) strOb.getOb();

        System.out.println(str);

        iOb = strOb;

//        v = (Integer) iOb.getOb();
    }
}
