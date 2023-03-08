package chapter12;

public class AutoBox3 {
    public static void main(String[] args) {
        Integer iOb, iOb2;
        int i;
        iOb = 100;

        System.out.println(iOb);

        ++iOb;
        System.out.println(iOb);

        iOb2 = iOb + (iOb / 3);
        System.out.println(iOb2);

        i = iOb + (iOb / 3);
        System.out.println(i);
    }
}
