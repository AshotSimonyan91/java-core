package chapter9.p2;

public class Protection2 extends chapter9.p1.Protection {
    public Protection2() {
        System.out.println("constructor another package");
//        System.out.println("n = " + n);
//        System.out.println("n_pri = " + n_pri);
        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);
    }
}
